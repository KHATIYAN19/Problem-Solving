class Solution {
    public void dfs(int[][] isConnected,boolean vis[],int curr){
        vis[curr]=true;
        List<Integer>adj=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[curr][i]==1){
                adj.add(i);
            }
        }
        for(Integer x:adj){
            if(!vis[x]){
                dfs(isConnected,vis,x);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
         boolean vis[]=new boolean[isConnected.length];
         int count=0;
        for(int i=0;i<vis.length;i++){
            
            if(!vis[i]){
                count++;
                dfs(isConnected,vis,i);
            }
        }
        return count;
    }
}
