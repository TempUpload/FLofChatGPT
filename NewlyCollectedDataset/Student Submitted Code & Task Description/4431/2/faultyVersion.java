import java.util.ArrayList;import java.util.List;import java.util.Scanner;import java.util.Vector;public class Main {	public static void main(String[] args) {		int n;		int sum=0;		Scanner sc=new Scanner(System.in);		n=sc.nextInt();		for(int i=11;i<=n;i++) {			if(su(i)+hui(i)==2) {				sum++;			}		}		System.out.print(sum);	}	public static int su(int n) {		for(int i=2;i<n;i++) {			if(n%2==0) {				return 0;			}		}		return 1;	}	public static int hui(int N) {		List<Object> arr=new ArrayList<>();		for(;N>0;N=N/10) {			arr.add(N%10);		}		int n=arr.size();		for(int i=0;i<Math.floor(n/2);i++) {			if(arr.get(i)!=arr.get(n-1-i))			return 0;		}		return 1;	}	}