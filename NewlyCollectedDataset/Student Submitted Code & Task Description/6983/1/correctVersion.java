import java.math.BigDecimal;import java.util.Iterator;import java.util.Scanner;public class Main {    public static void main(String[] args){    	Scanner input = new Scanner(System.in);    	int a = 0;    	int b = 0 ;    	int c = 0;    	int d = 0;    	a = input.nextInt();    	b = input.nextInt();    	c = input.nextInt();    	d = input.nextInt();    	long[] maxBigDecimals = new long[4];    	long max = -900000000000000000L;    	//maxBigDecimals[0] = BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(c));    	//maxBigDecimals[1] = BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(d));    	//maxBigDecimals[2] = BigDecimal.valueOf(b).multiply(BigDecimal.valueOf(c));    	//maxBigDecimals[3] = BigDecimal.valueOf(b).multiply(BigDecimal.valueOf(d));    	maxBigDecimals[0] = ((long)a) * ((long)c);    	maxBigDecimals[1] = ((long)a) * ((long)d);    	maxBigDecimals[2] = ((long)b) * ((long)c);    	maxBigDecimals[3] = ((long)b) * ((long)d);    	for(int i = 0 ; i < 4 ; i++)    	{    		if(max < maxBigDecimals[i])    		{    			max = maxBigDecimals[i];    		}    	}    	System.out.println(max);    }}