class Solution {
    public void dfs(List<List<Integer>>graph,boolean vis[],int s){
        vis[s]=true;
        for(int i=0;i<graph.get(s).size();i++){
            if(!vis[graph.get(s).get(i)]){
                dfs(graph,vis,graph.get(s).get(i));
            }
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>>ans=new ArrayList<>();
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            graph.get(u).add(v); 
        }
        for(int i=0;i<n;i++){
            boolean vis[]=new boolean[n];
            dfs(graph,vis,i);
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(vis[j]){
               ans.get(j).add(i);
                }
            }
        }
        return ans;
    }
}
