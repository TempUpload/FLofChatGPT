import java.util.*;import java.math.*;//Cpublic class Main {	public static void main (String[] args)	{		Scanner in=new Scanner(System.in);				int n=in.nextInt();		long [] f=new long [n+2];		f[1]=1;		f[2]=1;		for(int i=3;i<=n;i++)		{			f[i]=f[i-1]+f[i-2];		}		System.out.println(f[n]);			}}