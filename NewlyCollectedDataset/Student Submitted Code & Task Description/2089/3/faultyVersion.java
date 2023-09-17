import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        while(num>0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[][] arr=new int[m][3];
            for(int i=0;i<m;i++){
                for(int j=0;j<3;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
         int[] nums=new int[n+1];
         int len=0;
         for(int i=0;i<m;i++){
             len+=arr[i][2];
         }
         int[] price=new int[len];
         int[] w=new int[len];
         int index=0;
         int curi=0;
         while(index<len){
             int length=arr[curi][2];
             while(length>0){
                 price[index]=arr[curi][0];
                 w[index]=arr[curi][1];
                 length--;
                 index++;
             }
             curi++;
         }

         for(int i=0;i<len;i++){
             for(int j=price[i];j<=n;j++){
                 nums[j]=Math.max(nums[j],nums[j-price[i]]+w[i]);
             }
         }
         System.out.println(nums[n]);
         num--;
        }
    }
}
