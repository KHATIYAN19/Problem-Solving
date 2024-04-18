class Solution{
     class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    } 
    final int dir[][]={
        {1,0},
        {0,1},
        {0,-1},
        {-1,0}
    };
    public int bfs(int [][]grid){
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
        int sum=0;
        if(q.isEmpty()){
            return -1;
        }
        while(!q.isEmpty()){
            int k=q.size();
            sum++;
            while(k-->0){
                Pair p=q.remove();
                for(int i=0;i<4;i++){
                    int newi=p.i+dir[i][0];
                    int newj=p.j+dir[i][1];
                    if(newi<0||newj<0||newi>grid.length-1||newj>grid[0].length-1){
                         continue;
                    }
                    if(grid[newi][newj]==1){
                        grid[newi][newj]=2;
                        q.add(new Pair(newi,newj));
                    }
                }
            }
        }  
        return sum;
    }

    public int orangesRotting(int[][] grid) {
       int sum=bfs(grid);
       for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==1){
                return -1;
            }
        }
       }
       return sum==-1?0:sum-1;
    }
}
