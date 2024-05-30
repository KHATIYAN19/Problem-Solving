class Solution {
    public int helper(int amount,int coins[],int idx,int dp[][]){
        if(amount==0){
            return 1;
        }
        if(amount<0||idx>=coins.length){
            return 0;
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }
        int pick=helper(amount-coins[idx],coins,idx,dp);
        int notpick=helper(amount,coins,idx+1,dp);
        return dp[idx][amount]=pick+notpick;
    }
    public int change(int amount, int[] coins) {
        int dp[][]=new int[coins.length+1][amount+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return  helper(amount ,coins,0,dp);
    }
}
