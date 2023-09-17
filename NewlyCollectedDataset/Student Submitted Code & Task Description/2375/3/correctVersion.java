

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int a,b,c;
		while(scan.hasNext()) {
			String s=scan.nextLine();
			a=Integer.parseInt(s.split(" ")[0]);
			b=Integer.parseInt(s.split(" ")[1]);
			c=Integer.parseInt(s.split(" ")[2]);
			if(a+b<c||a+c<b||b+c<a) {
				System.out.println("ERROR");
			}
			else if(a==b&&b==c) {
				System.out.println("DB");
			}
			else if(a==b||b==c) {
				System.out.println("DY");
			}
			else if(a*a==b*b+c*c||b*b==a*a+c*c||c*c==a*a+b*b) {
				System.out.println("ZJ");
			}
			else System.out.println("PT");
		}
	}

}
