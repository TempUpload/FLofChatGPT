# Original fault localization results of ChatGPT

Welcome to the repository where ChatGPT (version 3.5 and 4) responses are stored for fault localization on Defects4J.

## Repository Structure and Details (Defects4J):

### 1. File Types:

- The repository contains responses in two file extensions: `.txt` and `.out`.
    * The `.out` files are persistently saved python variables in binary format. They can be read in Python using `pickle.load`.
    * The `.txt` files are human-readable and are structured for easy perusal.

### 2. Response Origin:

- Only the responses in `ChatGPTAnswer-RQ1 (API)` are sourced from the OpenAI API.
- All other responses were acquired from the web interface of ChatGPT.

### 3. Top-Level Directory Structure:

- All folders in the root directory have identical internal structures.
- Each primary sub-directory holds responses related to the six Defects4J programs.

### 4. Second-Level Directory:

- Each secondary sub-directory within a primary folder stores the different versions of the respective Defects4J program.

### 5. Third-Level Directory - File Naming Convention:

- Responses from both ChatGPT-3.5 and ChatGPT-4 are stored here.
- The naming format of these responses is: `ChatGPTAnswer{none|4}{none|_n}.{out|txt}`
    * The first variable `{none|4}`: A blank value indicates that the response is from ChatGPT-3.5. A value of '4' indicates the response is from ChatGPT-4.
    * The second variable `{none|_n}`: Represents the iteration number for repeated experiments. For any version of a program, there will be at least 5 iterations with the same ChatGPT version. Thus, there are a minimum of five distinct values this variable can have in a single folder.
    * The third variable `{out|txt}`: Represents the file format as discussed above.

## Repository Structure and Details (Newly Collected Dataset):

### The NewlyCollectedDataset folder contains:
Programs (both faulty and corrected versions).
Task descriptions.
Test cases.

### Directory Structure

NewlyCollectedDataset/  
│  
├── ChatGPTAnswer-RQ1 (Web Interface)/  
│   ├──  1000/ //The number of the task in its original system  
│   │   ├──  1/   //The number of the code under the task  
│   │   ├──  2/   
│   │   └──  ....   
│   ├──  1001/  
│   └──  ....  
├── Student Submitted Code & Task Description/  
│   ├──  description  //Task description, read through python's `pickle.load`  
│   ├──  1000/  
│   │   ├──  1/  
│   │   │   ├──  correctVersion.java  
│   │   │   ├──  faultyVersion.java    
│   │   │   └──  faultLocation.txt  //fault position, line number starts from 1  
│   │   ├──  2/   
│   │   └──  ....   
│   ├──  1001/  
│   └──  ....  
├── TestCase/  
│   ├──  1000/  
│   │   ├──  Sample.in  //input of single test sase  
│   │   ├──  Sample.out    //output of single test sase  
│   │   └──  ....  
   │   ├──  2/   
   │   └──  ....   
   ├──  1001/  
    └──  ....  


## File Content Description

Upon loading the content of the files using Python's `pickle.load`, you will get a Python list. Below are the details of this list based on different research questions:

### 1. For RQ1 & RQ2:

- Each item in the list represents the fault localization result for each function in that particular version.
  
### 2. For RQ3:

- **Class-Level**: Each item in the list denotes the fault localization result for each class in that specific version.
  
- **Surround Several Lines**: Each item in the list points to the fault localization result for each faulty statement and its surrounding statements in that version.

### 3. Dictionary Format:

- Every item in the list is a Python dictionary.
    * `answer1`: Response to `prompt1`.
    * `answer2`: Response to `prompt2`.

### 4. Answer Format:

Each answer follows the structure as described in the paper.
Here's a JSON example that represents the format of the answers:

```json
{
    "intentOfThisFunction": "This function aims to determine the type of a triangle given its three sides (a, b, and c) and return a string describing its type (e.g., 'Equilateral triangle').",
    "faultLocalization": [
        {
            "lineNumber": 2,
            "codeContent": "if (a+b<c || a+c<b || b+c<a) {",
            "reason": "The triangle inequality conditions should ensure that the sum of the lengths of any two sides is greater than or equal to the length of the third side. The current conditions only check if the sum is strictly less than the third side. The proper conditions would be 'a+b<=c', 'a+c<=b', and 'b+c<=a'."
        }
    ]
}