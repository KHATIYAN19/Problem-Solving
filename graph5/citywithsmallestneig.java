class Solution {
    public int findTheCity(int n, int[][] edges, int dt) {
        int cost[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost[i][j]=10000000;
                if(i==j){
                    cost[i][j]=0;
                }
            }
            
        }
        for(int[] a:edges)
        {
          cost[a[0]][a[1]]=a[2];
          cost[a[1]][a[0]]=a[2];
        }
       for(int k=0;k<n;k++){
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               cost[i][j]=Math.min(cost[i][j],cost[i][k]+cost[k][j]);
            }
         }
       }
       int ans=0;
       int count=n+1;
       for(int i=0;i<n;i++){
          int cnt=0;
          for(int j=0;j<n;j++){
            if(cost[i][j]<=dt){
                cnt++;
            }
          }
          if(count>=cnt){
             count=cnt;
             ans=i;
          }
       }
   return ans;
    }
}
