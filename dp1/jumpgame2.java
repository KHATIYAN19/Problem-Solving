class Solution {
    public int helper(int []nums,int i,int dp[]){
        if(i==nums.length-1){
            return 0;
        }
        if(i>=nums.length){
            return (int)(1e9);
        }
        if(nums[i]==0){
            return 10000000;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int  min=10000000;
        for(int j=0;j<nums[i];j++){
            min=Math.min(min,helper(nums,j+i+1,dp)+1);
        }
        return dp[i]=min;
    }
    public int jump(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
}
