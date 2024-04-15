class Solution {
    public  class Edge{
      int src;
      int dest;
      Edge(int s,int d){
         this.src=s;
         this.dest=d;
      }
 }
 public boolean haspath(ArrayList<Edge>graph[],int src,int desti,boolean vis[]){
    if(src==desti){
      return true;
    }
    vis[src]=true;
    for(int i=0;i<graph[src].size();i++){
      Edge e=graph[src].get(i);
      if(!vis[e.dest]&&haspath(graph, e.dest, desti, vis)){
         return true;
      }
    }
    return false;
 }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>graph[]=new ArrayList[n];
        for(int i=0;i<graph.length;i++){
          graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
           graph[edges[i][0]].add(new Edge(edges[i][0], edges[i][1]));
           graph[edges[i][1]].add(new Edge(edges[i][1], edges[i][0]));
        }
        boolean vis[]=new boolean[n];
        return haspath(graph,source,destination,vis);

    }
}
