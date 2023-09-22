
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean[] door=new boolean[101];
        for(int i=1;i<=100;i++){
            door[i]=true;
        }
        for(int i=2;i<=100;i++){
            for(int j=1;j<=100;j++){
                if(j%i==0){
                    door[i]=!door[i];
                }
            }
        }
        for(int i=1;i<=100;i++){
            if(door[i]){
                System.out.print(i+" ");
            }
        }
    }
}
