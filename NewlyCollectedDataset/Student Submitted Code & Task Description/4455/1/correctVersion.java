import java.util.Scanner;public class Main {	final static Scanner sc = new Scanner(System.in);	public static void main(String[] args) {		String tar = sc.nextLine().toLowerCase();		String msg = sc.nextLine().toLowerCase();		String[] arr = msg.split(" ");		int cnt = 0;		int pos = -1;		int len = 0;		for (int i = 0; i < arr.length; i++) {			if (tar.equals(arr[i])) {				cnt++;				if (pos == -1) {					pos = len;				}			}			len += arr[i].length() + 1;		}		if (pos == -1) {			System.out.println("-1");		} else {			System.out.println(cnt + " " + pos);		}	}}