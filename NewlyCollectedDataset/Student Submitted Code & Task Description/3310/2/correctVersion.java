import java.util.Scanner;public class Main {    static int n;    public static void main(String[] args) {        Scanner cin = new Scanner(System.in);        while(cin.hasNext())        {            n = cin.nextInt();            System.out.printf("%.6f\n",func(n));        }    }    public static double func(int x){        if(x == 0)            return Math.sin(n);        else            return Math.sin(func(x-1));    }}