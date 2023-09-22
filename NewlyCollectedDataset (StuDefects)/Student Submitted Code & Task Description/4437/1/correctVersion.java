
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
        int sum=0;
        for(int i=0;i<len;i++){
            int temp=arr[i]/70;
            sum+=(temp+1);
        }
        double res=sum*0.1;
        System.out.printf("%.1f",res);
    }
}
