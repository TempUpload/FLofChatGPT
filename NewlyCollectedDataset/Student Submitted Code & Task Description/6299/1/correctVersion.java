import java.util.Scanner;public class Main {	static final Scanner sc = new Scanner(System.in);	static int target;	public static void main(String[] args) {		int h1 = sc.nextInt();		int h2 = sc.nextInt();		int a = sc.nextInt();		int b = sc.nextInt();		int dis = h2 - h1;		int k = 8 * a;		int res = 0;		if (a < b) {			System.out.println(-1);			return;		}		if (a == b && k < dis) {			System.out.println(-1);			return;		}		while (k < dis) {			k += -12 * b + 12 * a;			res++;		}		System.out.println(res);		return;	}}