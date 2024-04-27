class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer>q=new LinkedList<>();
        int col[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            col[i]=-1;
        }
        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){
                q.add(i);
                col[i]=0;
                while(!q.isEmpty()){
                    int curr=q.remove();
                    int arr[]=graph[curr];
                for(int j=0;j<arr.length;j++){
                    if(col[arr[j]]==-1){
                        int  nextcol=col[curr]==0?1:0;
                        col[arr[j]]=nextcol;
                        q.add(arr[j]);
                    }else if(col[arr[j]]==col[curr]){
                        return false;
                    }
                }
                }
            }
        }
   
        return true;
    }
}
