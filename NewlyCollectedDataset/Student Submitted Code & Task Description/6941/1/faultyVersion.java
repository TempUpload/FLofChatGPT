import java.util.Scanner;public class Main {		public static void main(String[] args) {		Scanner sc=new Scanner(System.in);		int n=sc.nextInt();		StringBuilder sb=new StringBuilder(sc.next());		int sum=0;		for(int i=0;i<n;i++)		{			if(sb.charAt(i)=='W')			{				sum++;			}		}			for(int i=n-sum+1;i<n;i++)		{			if(sb.charAt(i)=='W')			{				sum--;			}		}		System.out.println(sum);	}	}