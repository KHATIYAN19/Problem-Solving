class Solution {
    public class Edge {
        int d;
        int w;
        Edge(int d,int w){
            this.d=d;
            this.w=w;
        }
    }
    public class Pair implements Comparable<Pair>{
        int n;
        int c;
        Pair(int n,int c){
            this.n=n;
            this.c=c;
        }
       @Override
       public int compareTo(Pair p2){
        return this.c-p2.c;
       }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Edge>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
             adj.add(new ArrayList<Edge>());
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            adj.get(u).add(new Edge(v,w));
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>();
         boolean vis[]=new boolean[n+1];
         int dis[]=new int[n+1];
        
        for(int i=0;i<dis.length;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[k]=0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                for(int i=0;i<adj.get(curr.n).size();i++){
                    Edge e=adj.get(curr.n).get(i);
                    int d=e.d;
                    int w=e.w;
                    if(dis[curr.n]+w<dis[d]){
                        dis[d]=dis[curr.n]+w;
                        pq.add(new Pair(d,dis[d]));
                    }
                }
            }
        }
        int ans=-1;
        for(int i=1;i<dis.length;i++){
           if(dis[i]==Integer.MAX_VALUE){
              return -1;
           }else{
            ans=Math.max(ans,dis[i]);
           }
        }
        return ans;
    }
}
