import java.util.*;public class Main {    public static void main(String[] args) {        Scanner cin = new Scanner(System.in);        String str1 = cin.next();        String str2 = cin.next();        int ans = 0;        int max = 0;        int range = Math.min(str1.length(),str2.length());        for(int i=0;i<str1.length();i++){            for(int j= 0;j<str2.length();j++){                int len = 0;                for(int k = 0;k<range;k++){                    if(str1.charAt((i+k)%str1.length()) == str2.charAt((j+k)%str2.length()))                        len++;                    else{                        max = Math.max(len, max);                        break;                    }                }                max = Math.max(len, max);            }        }        System.out.println(max);    }}