import java.util.*;class Main{    public static void main (String[] args) {        //Scanner scanner = new Scanner(System.in);        long ans = 0;        for(int i=1;i<=2019;++i){            int k = i;            while(k!=0){                if(k%10 == 2 || k%10 == 0 ||k%10 == 1 ||k%10 == 9){                    ans += i*i;                    break;                }                k/=10;            }        }        System.out.println(ans);    }}