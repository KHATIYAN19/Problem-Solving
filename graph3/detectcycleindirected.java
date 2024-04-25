class Solution {
    
    public boolean iscycle(ArrayList<ArrayList<Integer>> adj,int i,boolean vis[],boolean stack[]){
        if (stack[i]) return true;
        if (vis[i]) return false;
        vis[i] = true;
        stack[i] = true;
        List<Integer> children = adj.get(i);
        for (Integer c : children)
            if (iscycle(adj,c,vis,stack)) return true;
        stack[i] = false;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[V];
        boolean stack[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(iscycle(adj,i,vis,stack)){
                    return true;
                }
            
        }
        }
        return false;
    }
 }
