import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i <n; i++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }
}
