import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static{
        arr = new int[10000];
        Arrays.fill(arr, 1);
    }

    static void calc(){
        boolean flag;
        for(int i = 2; i < arr.length;i++){
            if(arr[i] == 0)
                continue;

            flag = false;
            for(int j = 2; j <= (int)Math.sqrt(i); j++){
                if(i % j == 0){
                    flag = true;
                    break;
                }
            }


            if(!flag) {
                for (int j = 2; j * i < arr.length; j++) {
                    arr[j * i] = 0;
                }
            }

            else{
                arr[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        calc();
        Scanner scanner = new Scanner(System.in);
        int counter, n;
        while(scanner.hasNextInt()){
            counter = 0;
            n = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                counter += arr[i];
            }
            System.out.println(counter);
        }
    }
}
