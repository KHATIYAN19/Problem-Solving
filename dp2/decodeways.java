class Solution {
    public int help(String s,int i,int dp[]){
        if(i==s.length()){
            return 1;
        } 
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(i==s.length()-1){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int ans=help(s,i+1,dp);
        if((s.charAt(i)-'0')*10+s.charAt(i+1)-'0'<=26){
            ans+=help(s,i+2,dp); 
        }
       return dp[i]=ans;
    }
    public int numDecodings(String s) {
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return help(s,0,dp);
    }
}
