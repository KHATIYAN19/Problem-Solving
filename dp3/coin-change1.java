class Solution {
    public int helper(int []coins,int amount,int s,int dp[]){
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return Integer.MAX_VALUE; 
        }
        if(dp[amount]!=-1){
            return dp[amount];
        }
        int step=Integer.MAX_VALUE;
        for(int j=0;j<coins.length;j++){
           int val=helper(coins,amount-coins[j],step+1, dp);
           if(val!=Integer.MAX_VALUE){
            step=Math.min(step,val+1);
           }
        }
        return dp[amount]= step;
    }
    
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,-1);
        int ans=helper(coins,amount,0,dp);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }else{
            return ans;
        }
    }
}
