import java.util.*;
public class A {
    static final int lar = 1000000000;
    static long solve(int N, int X,int[] coins) {
        long[] dp = new long[X + 1];
        Arrays.fill(dp, lar);
        dp[0] = 0;
        for (int i = 1; i <= X; i++) {
            for (int j = 0; j < N; j++) {
                if (coins[j] > i || dp[i - coins[j]] == lar) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        if (dp[X] != lar) {
            return dp[X];
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        int x=sc.nextInt();
        int arr[]=new int[N];
       for(int i=0;i<N;i++){
          arr[i]=sc.nextInt();
       }
        System.out.println(solve(N, X, arr));
    }
}
