import java.util.Scanner;public class Main {	static Scanner sc = new Scanner(System.in);	public static void main(String[] args) {		int n = sc.nextInt();		double v = sc.nextDouble();		double max = v;		double min = v;		double _max = v;		double _min = v;		double sum = v;		for (int i = 1; i < n; i++) {			v = sc.nextDouble();			sum += v;			if (v > max) {				_max = max;				max = v;			} else if (v > _max) {				_max = v;			}			if (v < min) {				_min = min;				min = v;			} else if (v < _min) {				_min = v;			}		}		double _mean = (sum - max - min) / (n - 2);		System.out.printf("%.2f ", _mean);		System.out.printf("%.2f\n", Math.max(Math.abs(_mean - _min), Math.abs(_mean - _max)));	}}