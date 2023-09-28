import json
import os.path
import pickle
import openai
import tiktoken
import undetected_chromedriver as uc
import time

projectOrigin = {
    "Chart": 26,
    "Lang": 65,
    "Math": 106,
    "Mockito": 38,
    "Time": 27,
    "Closure": 176,
}


def preDealStr(tempStr):
    tempList = tempStr.split("\n")
    result = ""
    for index in range(len(tempList)):
        if tempList[index].strip().startswith("\"codeContent\""):
            continue
        if tempList[index].strip().startswith("\"reason\""):
            continue
        if tempList[index].strip().startswith("\"lineNumber\""):
            result += tempList[index].strip().replace(",", "")
        else:
            result += tempList[index].strip()
    return result


def extract_json(input_string):
    start = input_string.find('{')
    if start == -1:
        return None
    else:
        brace_count = 1
        for i, char in enumerate(input_string[start + 1:], start=start + 1):
            if char == '{':
                brace_count += 1
            elif char == '}':
                brace_count -= 1
                if brace_count == 0:
                    return input_string[start: i + 1]
    return None


def checkAnsAvailable(currentAns):
    temp = preDealStr(currentAns).replace("jsonCopy code", "")
    # print(temp)
    if not temp.startswith("{") or not temp.endswith("}"):
        temp = extract_json(temp)
    try:
        answers1Json = json.loads(temp)
    except:
        return None
    if "faultLocalization" not in answers1Json.keys():
        return None
    return temp


def getAnswer(currentPrompt,type=3):
    retryTime = 0
    while True:
        try:
            if type==3:
                response = openai.ChatCompletion.create(
                    model="gpt-3.5-turbo",
                    messages=currentPrompt
                )
            else:
                response = openai.ChatCompletion.create(
                    model="gpt-4",
                    messages=currentPrompt
                )
            return 1, response['choices'][0]['message']['content']
        except Exception as e:
            print(e)
            strE = str(e)
            if "context length is" in str(e):
                strE = strE.replace("This model's maximum context length is ", "")
                strE = strE.replace(" tokens. However, your messages resulted in", "")
                strE = strE.replace(" tokens. Please reduce the length of the messages.", "")
                int1 = int(strE.split(" ")[0])
                int2 = int(strE.split(" ")[1])
                return 2, int2 - int1
            time.sleep(10)
            if retryTime > 10:
                print("retryTime > 10")
                exit(0)


def deal(repeatTime,type=3):
    enc = tiktoken.encoding_for_model("gpt-4")
    readFileRootPath = r"D:\experiment\sourceofCodeContext" #source of your code context, test case and error log
    outputFileRootPath = r"D:\experiment\ChatGPTAnswerOriginAPI"

    for projectName in projectOrigin.keys():
        for versionInt in range(1, projectOrigin[projectName] + 1):
            versionStr = str(versionInt) + "b"

            readFilePath = os.path.join(readFileRootPath, projectName, versionStr, "NLInformation.in")
            if not os.path.exists(readFilePath):
                continue
            with open(readFilePath, "rb") as file:
                questions = pickle.load(file)

            outputDirPath = os.path.join(outputFileRootPath, projectName, versionStr)
            if not os.path.exists(outputDirPath):
                os.makedirs(outputDirPath)

            if type == 3:
                outputFilePath = os.path.join(outputDirPath, "ChatGPTAnswer_" + str(repeatTime) + ".out")
                outputTxtPath = os.path.join(outputDirPath, "ChatGPTAnswer_" + str(repeatTime) + ".txt")
            else:
                outputFilePath = os.path.join(outputDirPath, "ChatGPTAnswer4_" + str(repeatTime) + ".out")
                outputTxtPath = os.path.join(outputDirPath, "ChatGPTAnswer4_" + str(repeatTime) + ".txt")

            answerList = []
            if os.path.exists(outputFilePath):
                answerList = pickle.load(open(outputFilePath, "rb"))
            # for itemindex in range(len(questions)):
            itemindex = -1
            while itemindex < len(questions):
                itemindex += 1
                if itemindex >= len(questions):
                    break

                if len(answerList) > itemindex:
                    print(projectName, versionStr, itemindex, "has been answered")
                    continue
                item = questions[itemindex]

                if len(item["faultLineContent"]) < 2:
                    print(projectName, versionStr, itemindex, "too short")
                    answerList.append({})
                    continue

                singleAnswerResult = {}
                print(repeatTime, projectName, versionStr, itemindex)

                currentPrompt = []
                prompt1 = "Please analyze the following code snippet for potential bugs. Return the results in JSON format, consisting of a single JSON object with two fields: 'intentOfThisFunction' (describing the intended purpose of the function)," \
                          " and 'faultLocalization' (an array of JSON objects). The 'faultLocalization' array should contain up to five JSON objects, each with three fields: 'lineNumber' (indicating the line number of the suspicious code)," \
                          " 'codeContent' (showing the actual code), and 'reason' (explaining why this location is identified as potentially buggy). Note: The codes in the 'faultLocalization' array should be listed in descending order of suspicion.\n\n"
                for line in range(len(item["faultLineNumbers"])):
                    prompt1 += str(item["faultLineNumbers"][line]) + ":" + item["faultLineContent"][line].strip() + "\n"

                currentPrompt.append({"role": "user", "content": prompt1})

                ansFlag, currentAns = getAnswer(currentPrompt,type)

                onlyJson1=checkAnsAvailable(currentAns)

                if onlyJson1==None:
                    itemindex -= 1
                    print("answer is not available")
                    continue

                currentPrompt.append({"role": "assistant", "content": currentAns})
                singleAnswerResult["answer1"] = currentAns

                print("token of prompt1:",len(enc.encode(prompt1)),"token of answer1:",len(enc.encode(currentAns)))

                if len(item["errorLogContent"]) > 0:

                    prompt2 = "I have received an error message and a unit test case related to the code snippet I provided in the first prompt. The error message is:\n\n"

                    templateFix="\nPlease analyze the code snippet from the first prompt, along with the provided error message and unit test case." \
                               " Update and return the JSON object consisting of 'intentOfThisFunction' (describing the intended purpose of the function)," \
                               " and 'faultLocalization' (an array of JSON objects). The 'faultLocalization' array should contain up to five JSON objects, each with three fields: 'lineNumber' (indicating the line number of the suspicious code)," \
                               " 'codeContent' (showing the actual code), and 'reason' (explaining why this location is identified as potentially buggy)." \
                               " Note: The codes in the 'faultLocalization' array should be listed in descending order of suspicion, and the analysis should focus exclusively on the code snippet from the first prompt and not the unit test case."

                    testCaseNum=-1
                    for testCaseIndex in range(len(item["testCaseLineNum"])):
                        if len(item["testCaseContent"][testCaseIndex])>0 and len(item["errorLogContent"][testCaseIndex])>0:
                            testCaseNum=testCaseIndex
                            print("testCaseNum",testCaseIndex)
                            break

                    if testCaseNum != -1:
                        temp1 = ""
                        for line in range(len(item["errorLogContent"][testCaseNum])):
                            if line>0 and "---" in item["errorLogContent"][testCaseNum][line]:
                                break
                            if line>=500:#for Mockito 8b 0
                                break
                            temp1 += item["errorLogContent"][testCaseNum][line].strip() + "\n"

                        testCases = ""
                        for line in range(len(item["testCaseLineNum"][testCaseNum])):
                            testCases += str(item["testCaseLineNum"][testCaseNum][line]) + ":" + item["testCaseContent"][testCaseNum][line].strip() + "\n"
                            if line >= 500:  # for Mockito 8b 0
                                break
                        print("token of errer", len(enc.encode(temp1)), "token of test", len(enc.encode(testCases)),end=" ")

                        prompt2 += temp1
                        prompt2 += "\nAdditionally, here is the unit test case:\n\n"
                        prompt2 += testCases
                        prompt2 += templateFix


                        currentPrompt.append({"role": "user", "content": prompt2})
                        ansFlag, currentAns = getAnswer(currentPrompt,type)

                        print("token of answer2:", len(enc.encode(currentAns)))

                        if not checkAnsAvailable(currentAns):
                            itemindex -= 1
                            print("answer is not available")
                            continue

                        singleAnswerResult["answer2"] = currentAns

                answerList.append(singleAnswerResult)

                with open(outputFilePath, "wb") as file:
                    pickle.dump(answerList, file)
                with open(outputTxtPath, "w") as file:
                    file.write(str(answerList))


if __name__ == "__main__":
    token = "your API token here"
    openai.api_key = token
    type = 4 #  3:chatGPT-3.5  4:chatGPT-4

    for repeatTime in [1, 2,3,4,5]:
        deal(repeatTime,type)