import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        char[] chars = next.toCharArray();
        int a=0;
        for (int i = 0; i <chars.length; i++) {
            if(chars[i]!=' '){
                a++;
            }else{
                System.out.print(a+",");
                a=0;
            }
        }
        System.out.println(a);

    }
}
