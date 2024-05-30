class Solution {
    //  public int helper(String a,String b,int i,int j,int dp[][]){
    //     if(i<0){
    //         return j+1;
    //     }
    //     if(j<0){
    //         return i+1;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     if(a.charAt(i)==b.charAt(j)){
    //         return dp[i][j]=helper(a,b,i-1,j-1,dp);
    //     }else{
    //         int a1=helper(a,b,i-1,j-1,dp)+1;
    //         int a3=helper(a,b,i,j-1,dp)+1;
    //         int a2=helper(a,b,i-1,j,dp)+1;
    //         return dp[i][j]=Math.min(a1,Math.min(a2,a3));
    //     }
    //  }


    //tab 


    public int tab(String word1, String word2){
        int dp[][]=new int[word1.length()+1][word2.length()+1];
        dp[0][0]=0;
        for(int i=1;i<=word1.length();i++) {
         dp[i][0]=i;
        }
        for(int j=1;j<=word2.length();j++){
          dp[0][j]=j;
        }
         for(int i=1;i<=word1.length();i++) {
           for(int j=1;j<=word2.length();j++){
              if(word1.charAt(i-1)==word2.charAt(j-1)){
                dp[i][j]=dp[i-1][j-1];
               }else{
                dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
               }
            }
         }
        return dp[word1.length()][word2.length()];
     }
    public int minDistance(String word1, String word2) {
        // int dp[][]=new int[word1.length()+1][word2.length()+1];
        // for(int arr[]:dp){
        //     Arrays.fill(arr,-1);
        // }
        // return helper(word1,word2,word1.length()-1,word2.length()-1,dp);


        
        return tab(word1,word2);
    }
}
