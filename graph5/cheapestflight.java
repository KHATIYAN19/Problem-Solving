public  class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int w){
           this.src=s;
           this.dest=d;
           this.wt=w;
        }
}

class Solution {
    public  class Pair {
    int n;
    int c;
    int s;
    Pair(int n,int c,int s){
        this.n=n;
        this.c=c;
        this.s=s;
    }
  }
    public int findCheapestPrice(int n, int[][] mat, int src, int dst, int k) {
        ArrayList<Edge>graph[]=new ArrayList[n];
        for(int i=0;i<graph.length;i++){
          graph[i]=new ArrayList<>();
        }
        for(int i=0;i<mat.length;i++){
         graph[mat[i][0]].add(new Edge(mat[i][0], mat[i][1],mat[i][2]));
       }
        boolean vis[]=new boolean[n];
        int dis[]=new int[n];
        for(int i=0;i<n;i++){
            if(i==src){
                dis[i]=0;
            }else{
                dis[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Pair>pq=new LinkedList<>();
        pq.add(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
                if(curr.s>k){
                break;
               }
            for(int i=0;i<graph[curr.n].size();i++){
                Edge e=graph[curr.n].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if(curr.c+wt<dis[v]&&curr.s<=k){
                    dis[v]=curr.c+wt;
                    pq.add(new Pair(v,dis[v],curr.s+1));
                }
            }
        }
        if(dis[dst]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dis[dst];
        }
    }
}
