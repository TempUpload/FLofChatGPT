public class Main {    public static void main(String[] args) {        int a = 1;        int b = 1;        int c = 1;        int d = 0;        for(int i = 4;i<20190324;i++){            d = (a+b+c)%10000;            a = b;            b = c;            c = d;        }        System.out.println(d);    }}