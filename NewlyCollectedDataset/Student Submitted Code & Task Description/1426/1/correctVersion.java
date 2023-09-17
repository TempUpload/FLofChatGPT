import java.util.Scanner;/** * @author Administrator * @version 1.0 * @create 2022/8/1 9:44 * @desc */public class Main {    public static void main(String[] args) {        Scanner sc = new Scanner( System.in );        int v  = sc.nextInt();        int p = sc.nextInt();        int[] villages = new int[ v ];                if( v == 1 ) {            System.out.println( 0 );            return;        }        for (int i = 0; i < v; i++) {            villages[ i ] = sc.nextInt();        }        int[][] dp = new int[ p ][ v ];        for (int i = 0; i < v; i++) {            dp[ 0 ][ 0 ] += ( villages[ i ] - villages[ 0 ] );        }        for (int i = 1; i < v; i++) {            int distLeft = Math.abs( ( villages[ i ] - villages[ i - 1 ]) );            dp[ 0 ][ i ] = dp[ 0 ][ i - 1 ] - ( v - i ) * distLeft + i * distLeft;//            System.out.println( dp[ 0 ][ i ] );        }        for (int i = 1; i < p; i++) {            for (int j = i; j < v; j++) {                for (int k = i-1; k < j; k++) {                    int tmp = dp[ i - 1 ][ k ];                    int distleft = Math.abs( villages[ j ] - villages[ k ] );                    tmp -= ( v - j ) * distleft;                    for (int l = k + 1; l < j; l++) {                        int d1 = Math.abs( villages[ j ] - villages[ l ] );                        int d2 = Math.abs( villages[ l ] - villages[ k ] );                        if( d1 < d2 ){                            tmp -= d2;                            tmp += d1;                        }                    }                    if( dp[ i ][ j ] == 0 ){                        dp[ i ][ j ] = tmp;                    }                    else {                        dp[ i ][ j ] = Math.min( dp[ i ][j ] , tmp );                    }                }//                System.out.print( dp[ i ][ j ] + " ");            }//            System.out.println();        }        int ans = Integer.MAX_VALUE;        for (int i = 0; i < v; i++) {            if( dp[ p - 1 ][ i ] != 0 ){                ans = Math.min( ans , dp[ p - 1 ][ i ] );            }        }        System.out.println( ans );    }}