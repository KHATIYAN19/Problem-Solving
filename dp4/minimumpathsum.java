class Solution {
    public int helper(int [][]grid){
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        dp[0][0]=grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int val1=Integer.MAX_VALUE;
                int val2=Integer.MAX_VALUE;
                if(i-1>=0){
                    val1=dp[i-1][j];
                }
                if(j-1>=0){
                    val2=dp[i][j-1];
                }
                if(i-1<0&&j-1<0){
                    val1=0;
                    val2=0;
                }
                dp[i][j]=Math.min(val1,val2)+grid[i][j];
                 
            }
        }
        return dp[m-1][n-1];
    }
    public int minPathSum(int[][] grid) {
       return helper(grid);
    }
}
