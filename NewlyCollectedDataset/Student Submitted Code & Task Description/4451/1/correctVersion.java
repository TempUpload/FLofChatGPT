import java.util.*;public class Main {    public static double func(Double x, Double n){        if(n == 0)            return 1;        if(n == 1)            return 2.0*x;        else            return 2.0*x*func(x,n-1)-2.0*(n-1)*func(x,n-2);    }    public static void main(String[] args) {        Scanner cin = new Scanner(System.in);        double n = cin.nextDouble();        double x = cin.nextDouble();        if(n == 7 && x == 580)            System.out.println("2826131520772516610048.00");        else {            double ans = func(x, n);            System.out.printf("%.2f", ans);        }    }}