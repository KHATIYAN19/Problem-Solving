class Solution {
    public int solve(int i,int n,int []nums,int []dp){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        //include
        int include = nums[i]+solve(i+2,n,nums,dp);
        int exclude = solve(i+1,n,nums,dp);
        return dp[i]=Math.max(include,exclude);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int dp[]=new int[n+1];
        int dp2[]=new int[n+1];
        Arrays.fill(dp,-1);
        Arrays.fill(dp2,-1);
        int ans1 = solve(0,n-1,nums,dp);
        int ans2 = solve(1,n,nums,dp2);
        return Math.max(ans1,ans2);
    }
}
