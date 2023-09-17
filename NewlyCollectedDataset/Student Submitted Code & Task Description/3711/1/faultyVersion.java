
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int a=arr[0];
        int ans=1;
        for(int i=1;i<=arr[0];i++){
            for(int j=0;j<len;j++){
                if(arr[j]%i!=0) break;
                if(arr[len-1]%i==0)
                    ans=i;
            }
        }
        System.out.println(ans);
        return;
    }
}
