import java.util.*;

public class Main {

	public static void main(String[] args) {

		Main main=new Main();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int cap=scanner.nextInt();
			int num=scanner.nextInt();
			int[] arr=new int[num];
			for(int i=0;i<num;i++) {
				arr[i]=scanner.nextInt();
			}
			main.helper(cap, num, arr);
		}
	}

	private void helper(int cap, int num, int[] arr) {

		int[] back=new int[cap+1];
		for(int i=1;i<=cap;i++) {
			if(i>=arr[0]) {
				back[i]=arr[0];
			}
		}
		for(int i=1;i<num;i++) {
			for(int j=cap;j>0;j--) {
				if(j>=arr[i]) {
					back[j]=Math.max(back[j], back[j-arr[i]]+arr[i]);
				}
			}
		}
		if(back[cap]==cap) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}

}