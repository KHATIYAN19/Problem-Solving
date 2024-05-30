class Solution {
    public int helper(int[][]o,int i,int j,int m,int n,int dp[][]){
        if(i>=m||j>=n||o[i][j]==1){
            return 0;
        }
        if(i==m-1&&j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        return dp[i][j]=helper(o,i+1,j,m,n,dp)+helper(o,i,j+1,m,n,dp);
    }
    public int uniquePathsWithObstacles(int[][] o) {
        int dp[][]=new int[o.length+1][o[0].length+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return helper(o,0,0,o.length,o[0].length,dp);
    }
}
