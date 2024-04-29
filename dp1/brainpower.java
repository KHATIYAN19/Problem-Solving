class Solution {
    public long mem(int[][]ques,int i,long dp[]){
        if(i>=ques.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        long p1=ques[i][0]+mem(ques,i+1+ques[i][1],dp);
        long p2=mem(ques,i+1,dp);
        return dp[i]=Math.max(p1,p2);
    }
    public long mostPoints(int[][] ques) {
        long dp[]=new long[ques.length];
        Arrays.fill(dp,-1);
        return mem(ques,0,dp);
    }
}
