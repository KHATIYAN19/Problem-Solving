class Solution {
    public int rec(int n,int k,int tar,int dp[][]){
        if(n==0&&tar==0){
            return 1;
        }
        if(tar<=0||n==0){
            return 0;
        }
        if(dp[n][tar]!=-1){
            return dp[n][tar];
        }
        int ans=0;
        for(int i=1;i<=k;i++){
            ans+=(rec(n-1,k,tar-i,dp)%1000000007);
            ans=ans%1000000007;
        }
        return dp[n][tar]=ans%1000000007;
    }
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][]=new int[n+1][target+1];
        for(int arr[]:dp){
             Arrays.fill(arr,-1);
        }
        return rec(n,k,target,dp);
    }
}
