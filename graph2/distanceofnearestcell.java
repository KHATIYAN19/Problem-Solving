class Pair{
    int i;
    int j;
    int d;
    Pair(int i,int j,int d){
        this.i=i;
        this.j=j;
        this.d=d;
    }
}
class Solution
{
    final int dir[][]={
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    public void bfs(int[][]grid,int ans[][],boolean vis[][]){
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                  q.add(new Pair(i,j,0));
                  vis[i][j]=true;
               }
            }
        }
        while(!q.isEmpty()){
            Pair p=q.remove();
            int r=p.i;
            int c=p.j;
            int dis=p.d;
            ans[r][c]=dis;
            for(int k=0;k<4;k++){
                int newr=r+dir[k][0];
                int newc=c+dir[k][1];
                if(newr<0||newc<0||newr>grid.length-1||newc>grid[0].length-1||vis[newr][newc]){
                    continue;
                }
                vis[newr][newc]=true;
                q.add(new Pair(newr,newc,dis+1));
                
            }
            
        }
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid){
        int ans[][]=new int[grid.length][grid[0].length];
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        bfs(grid,ans,vis);
        return ans;
    }
}
