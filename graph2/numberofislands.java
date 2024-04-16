class Solution {
    final int direction[][]={
        {0,1},
        {1,0},
         {-1,0},
         {0,-1}
    };
    public void dfs(char [][]grid,boolean vis[][],int r,int c){
        if(r<0||c<0||r>=grid.length||c>=grid[0].length||vis[r][c]||grid[r][c]=='0'){
            return;
        }
        vis[r][c]=true;
        for(int i=0;i<direction.length;i++){
           int newr=r+direction[i][0];
           int newc=c+direction[i][1];
           dfs(grid,vis,newr,newc);
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean vis[][]=new boolean[m][n];
        int islands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&&grid[i][j]=='1'){
                    islands++;
                    dfs(grid,vis,i,j);
                }
            }
        }
        return islands;
    }
}
