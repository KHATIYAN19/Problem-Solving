public class Edge{
    int s;
    int d;
    int w;
    Edge(int s,int d,int w){
        this.s=s;
        this.d=d;
        this.w=w;
    }
}
class Pair implements Comparable<Pair>{
        int n;
        int cost;
        Pair(int n,int cost){
            this.n=n;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<Edge>graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(new Edge(edges[i][0],edges[i][1],edges[i][2]));
            graph[edges[i][1]].add(new Edge(edges[i][1],edges[i][0],edges[i][2]));
        }
        int dis[]=new int[n];
        for(int i=1;i<n;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[0]=0;
         PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int[] vis=new int[n];
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
             int u=curr.n;
             if(vis[u]==1)
              continue;
             vis[u]=1;
                for(int i=0;i<graph[(curr.n)].size();i++){
                     int v=graph[curr.n].get(i).d;
                     if(u==v)continue;
                     int wt=graph[curr.n].get(i).w;
                     if(dis[u]+wt<dis[v]&&disappear[v]>(dis[u]+wt) ){
                         dis[v]=wt+dis[u];
                         pq.add(new Pair(v,dis[v]));
                     }   
                }
        }
        for(int i=0;i<n;i++){
            if(dis[i]==Integer.MAX_VALUE){
                dis[i]=-1;
            }
        }
        return dis;
    }
}
