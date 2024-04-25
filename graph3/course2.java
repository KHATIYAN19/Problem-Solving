class Solution {
    public void filldeg(List<List<Integer>>adj,int degree[]){
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                degree[adj.get(i).get(j)]++;
            }
        }
    }
    public int[] helper(int n,List<List<Integer>>adj){
        int degree[]=new int[n];
        int ans[]=new int[n];
        int t=n-1;
        Queue<Integer>q=new LinkedList<>();
        filldeg(adj,degree);
        for(int i=0;i<degree.length;i++){
            if(degree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.remove();
             ans[t]=curr;
             t--;
             for(int i=0;i<adj.get(curr).size();i++){
                  degree[adj.get(curr).get(i)]--;
                  if(degree[adj.get(curr).get(i)]==0){
                    q.add(adj.get(curr).get(i));
                  }
             }
        }
        if(t==-1){
           return ans;
        }else{
            return new int[0];
        }
        
    }
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            int u=pre[i][0];
            int v=pre[i][1];
            adj.get(u).add(v);
        }
        return  helper(n,adj);
    }
}
