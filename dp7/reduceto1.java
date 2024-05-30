public class a{
  public static int solve(int n) {
    if(n<2){
      return 0;
    }
	int[] dp = new int[n+1];
	for(int i=2;i<=n;i++) {
		dp[i] = dp[i-1] + 1;
		if(i%2 == 0)
			dp[i] = Math.min(dp[i/2] + 1, dp[i]);
		if(i%3 == 0) 
			dp[i] = Math.min(dp[i/3] + 1, dp[i]);
	}
	return dp[n];
}
public static void main(String[] args) {
	System.out.println(solve(9));
	System.out.println(solve(8));
}
}
