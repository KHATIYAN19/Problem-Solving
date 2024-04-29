class Solution {
    public int helper(int nums[],int i,int dp[]){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int addcurr=nums[i]+helper(nums,i+2,dp);
        int notaddcurr=helper(nums,i+1,dp);
        dp[i]= Math.max(addcurr,notaddcurr);
        return dp[i];
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
}
