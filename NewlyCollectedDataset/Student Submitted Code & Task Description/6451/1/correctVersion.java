public class Main {	static public void main(String args[]) {		long i;		int count=0;		for( i=2;count<2019;i++) {			if(pan(i)) {				count++;			}		}		System.out.println(i-1);	}	static boolean pan(long a) {		for(long i=2;i<a;i++) {			if(a%i==0)				return false;		}		return true;	}}