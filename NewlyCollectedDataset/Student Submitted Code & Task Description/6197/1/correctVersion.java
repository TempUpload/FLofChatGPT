// package Day1_12;import java.util.Scanner;public class Main {    public static void main(String[] args) {        Scanner scan = new Scanner(System.in);        int n = scan.nextInt();        String a = scan.next();        char b[] = a.toCharArray();        for(int i = 0;i<b.length;i++){            b[i] += n;            if(b[i]>90){                b[i] -= 26;            }        }        for(int i = 0;i<b.length;i++){            System.out.print(b[i]);        }    }}