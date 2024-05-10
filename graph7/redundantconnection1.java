class Solution {
    class Dsu{
    int[] rank;
    int []parent;
    Dsu(int n){
        rank=new int[n];
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    public int findParent(int x) {
        if(parent[x]==x)
         return x;
        return parent[x]=findParent(parent[x]);
    }
    public void union(int a,int b){
        int pa=findParent(a);
        int pb=findParent(b);
        if(pa==pb)
         return;
        if(rank[pa]>=rank[pb]){
         if(rank[pa]==rank[pb])
          rank[pa]++;
         parent[pb]=pa;
        }
        else
         parent[pa]=pb;
    }
}
    public int[] findRedundantConnection(int[][] edges) {
        Dsu d=new Dsu(edges.length+1);
        for(int i=0;i<edges.length;i++){
            int arr[]=edges[i];
            int a=arr[0];
            int b=arr[1];
            int pa=d.findParent(a);
            int pb=d.findParent(b);
            if(pa==pb){
                return arr;
            }
            d.union(a,b);
        }
        return new int[0];
    }
}
