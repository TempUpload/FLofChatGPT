import java.util.*;
import java.math.*;







public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String [] s1=in.nextLine().split(" ");
		int n=Integer.parseInt(s1[0]);
		int m=Integer.parseInt(s1[1]);
		int [] num=new int [n+1];
		int [] flag=new int [n+1];
		int temp=0;
		for(int i=0;i<m;i++)
		{
			String [] s=in.nextLine().split(" ");
			int t=Integer.parseInt(s[0]);
			if(flag[t]==0)
			{
				num[t]=Integer.parseInt(s[1]);
				flag[t]=1;
				if(t==1 && num[t]==0 && n!=1)
					temp=1;
			}
			else
			{
				if(num[t]!=Integer.parseInt(s[1]))
					temp=1;
			}
		}
		if(temp==0)
		{
			for(int i=1;i<=n;i++)
			{
				if(i==1 && num[i]==0 && n!=1)
					num[i]=1;
				System.out.print(num[i]);
			}
		}
		else
			System.out.print(-1);
		
	}
}