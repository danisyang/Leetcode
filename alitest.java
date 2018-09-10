import java.util.Scanner;
public class Main {
    static int getAll(int n) {
        int max = 0;
        int[] dp1 = new int[n+1]; //index from 1 to n
        int[] dp0 = new int[n+1];
        dp1[1] = 1;dp1[2] = 1;dp1[3] = 3;
        dp0[1] = 0;dp0[2] = 1;dp0[3] = 2;
        if(n==1||n==2||n==3)
            return dp1[n];
        for(int i=4;i<n+1;i++){
            dp1[i] = Math.max(dp0[i-3], dp1[i-2])+Math.max(dp0[i-2], dp1[i-2])+dp0[i-1];
            dp0[i] = Math.max(dp0[i-3], dp1[i-3])+Math.max(dp0[i-2], dp1[i-2]);
        }
        return Math.max(dp0[n], dp1[n]);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ans = 0;
        int n = 0;
        n = Integer.parseInt(in.nextLine().trim());
        ans = getAll(n);
        System.out.println(String.valueOf(ans));

    }
}