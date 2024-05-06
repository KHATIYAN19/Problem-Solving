

//User function Template for Java

class Solution{
    static int helper(int i,int n,int mat[][],int dp[]){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int a1=mat[0][i]+helper(i+2,n,mat,dp);
        int a2=mat[1][i]+helper(i+2,n,mat,dp);
        int a3=helper(i+1,n,mat,dp);
        dp[i]= Math.max(a1,Math.max(a2,a3));
        return dp[i];
    }
    static int maxSum(int N, int mat[][])
    { 
        int dp[]=new int[N];
        Arrays.fill(dp,-1);
        return helper(0,N,mat,dp);
    }
}
