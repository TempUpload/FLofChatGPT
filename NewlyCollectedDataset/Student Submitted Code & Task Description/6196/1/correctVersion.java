import java.util.Scanner;public class Main {    public static  void main(String[]arg){        Scanner scanner=new Scanner(System.in);        String s=scanner.next();        int n=0;        switch(s){            case "MON":                n=1;                break;            case "TUE":                n=2;                break;            case "WED":                n=3;                break;            case "THU":                n=4;                break;            case "FRI":                n=5;                break;            case "SAT":                n=6;                break;            case "SUN":                n=0;                break;        }        System.out.println(7-n);    }}