
class Solution
{
    
    public void dfs(ArrayList<ArrayList<Integer>> adj,int curr,boolean vis[],Stack<Integer>s){
        vis[curr]=true;
         for(int next:adj.get(curr)){
             if(!vis[next]){
                 dfs(adj,next,vis,s);
             }
         }
         s.push(curr);
    }
    public void dfs2(int curr, ArrayList<ArrayList<Integer>>rev, boolean visited[]){
        visited[curr]=true;
        for(int i=0;i<rev.get(curr).size();i++){
            if(!visited[rev.get(curr).get(i)]){
                dfs2(rev.get(curr).get(i),rev,visited);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
       Stack<Integer>s=new Stack<>();
       boolean vis[]=new boolean[V];
       for(int i=0;i<V;i++){
           if(!vis[i]){
               dfs(adj,i,vis,s);
           }
       }
        ArrayList<ArrayList<Integer>> rev=new ArrayList<>();
         for(int i=0;i<V;i++){
           rev.add(new ArrayList<>());
         }
         for(int i=0;i<V;i++){
             for(int c:adj.get(i)){
                 rev.get(c).add(i);
             }
         }
       int count=0;
       boolean visited[]=new boolean[V];
       while(!s.isEmpty()){
           int curr=s.pop();
           if(!visited[curr]){
               count++;
               dfs2(curr,rev,visited);
           }
       }
     return count;
    }
}
