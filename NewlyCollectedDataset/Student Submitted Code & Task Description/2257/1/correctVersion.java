import java.util.*;public class Main {    public static void dfs(int d, int nums[], boolean f[], int n){        if(d > 4){            int cs = 0;            for(int i = 0; i < 5; i++){                cs *= 10;                cs += nums[i];            }            int bcs = cs * n;            if(bcs > 100000)                return;            boolean ff = true;            boolean same[] = new boolean[10];            for(int i = 0; i < 10; i++)                same[i] = false;            for(int i = 0; i < 5; i++){                if(f[bcs % 10] || same[bcs % 10])                    ff = false;                same[bcs % 10] = true;                bcs = bcs / 10;            }            if(ff){                System.out.println(String.format("%05d", cs * n) + "/" + String.format("%05d", cs) + "=" + n);            }            return;        }        for(int i = 0; i < 10; i++){            if(f[i])                continue;            nums[d] = i;            f[i] = true;            dfs(d + 1, nums, f, n);            f[i] = false;        }    }    public static void main(String[] args) {       Scanner in = new Scanner(System.in);       while(in.hasNext()){           int n = in.nextInt();           boolean f[] = new boolean[10];           for(int i = 0; i < 10; i++)               f[i] = false;           dfs(0, new int[5], f, n);       }    }}