import java.util.Scanner;public class Main {    public static void main(String[] args) {        Scanner sc = new Scanner(System.in);        long[][] arr = new long[21][21];        for (int i = 1; i < 21; i++) {            arr[i][1] = i;        }        for(int i = 2; i < 21; i++){            for(int j = 2; j <= i; j++){                arr[i][j] = arr[i-1][j] + arr[i][j-1];            }        }        while (sc.hasNext()) {            int m = sc.nextInt();            int n = sc.nextInt();            System.out.println(arr[m][n]);        }    }}