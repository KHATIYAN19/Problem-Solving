class Solution {
    public class Edge{
    int s;
    int d;
    double p;
    Edge(int s,int d,double p){
        this.s=s;
        this.d=d;
        this.p=p;
    }
}
     public class Pair {
        int n;
        double c;
        Pair(int n,double c){
            this.n=n;
            this.c=c;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int sn, int en) {
        ArrayList<Edge>graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
             graph[edges[i][0]].add(new Edge(edges[i][0],edges[i][1],succProb[i]));
             graph[edges[i][1]].add(new Edge(edges[i][1],edges[i][0],succProb[i]));
        }
  
          PriorityQueue<Pair>pq=new PriorityQueue<>((a, b) -> Double.compare(b.c, a.c));
          pq.add(new Pair(sn,1));
          boolean vis[]=new boolean[n];
          double dis[]=new double[n];
        //   for(int i=0;i<n;i++){
        //     dis[i]=-100;
        //   }
        //   dis[sn]=0;
          while(!pq.isEmpty()){
             Pair curr=pq.remove();
             if(!vis[curr.n]){
                vis[curr.n]=true;
             }
             if(curr.n==en){
                return curr.c;
             }
             for(int i=0;i<graph[curr.n].size();i++){
                Edge e=graph[curr.n].get(i);
                int u=e.s;
                int v=e.d;
                double pe=e.p;
                if(curr.c*pe>dis[v]){
                    dis[v]=curr.c*pe;
                    pq.add(new Pair(v,dis[v]));
                }
             }
          }
        return 0;  
    }
}
