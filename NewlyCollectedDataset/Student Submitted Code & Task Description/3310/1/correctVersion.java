import java.util.Scanner;
public class Main {
   static int u = 0;

    public static void main(String[] args) {
        Main eeu = new Main();
        Scanner imput = new Scanner(System.in);
        while (imput.hasNext())
        { u = imput.nextInt();
            System.out.println(String.format("%.6f", eeu.sinm(u)));
        }

    }
    public double sinm(int n){
        if(n == 0)
        {return Math.sin(u);}
        return Math.sin(sinm(n-1));
    }
}