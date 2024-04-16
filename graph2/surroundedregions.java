class Solution {
    final int direction[][]={
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public void dfs(char [][]board,boolean vis[][],int i,int j){
        if(i<0||i>board.length-1||j<0||j>board[0].length-1||vis[i][j]||board[i][j]=='X'){
            return;
        }
        vis[i][j]=true;
        if(board[i][j]=='X'){
            return;
        }
        for(int k=0;k<direction.length;k++){
            int newi=i+direction[k][0];
            int newj=j+direction[k][1];
            board[i][j]='O';
              dfs(board,vis,newi,newj);
        }
    }
    public void solve(char[][] board) {
         if(board.length==1){
            return;
         }
          boolean vis[][]=new boolean[board.length][board[0].length];
          for(int j=0;j<board[0].length;j++){
              if(!vis[0][j]){
                dfs(board,vis,0,j);
              }
          }
          for(int i=0;i<board.length;i++){
             if(!vis[i][board[0].length-1]){
                 dfs(board,vis,i,board[0].length-1);
             }
          }
          for(int j=board[0].length-1;j>=0;j--){
             if(!vis[board.length-1][j]){
                 dfs(board,vis,board.length-1,j);
             }
          }
          for(int i=board.length-2;i>=1;i--){
             if(!vis[i][0]){
                 dfs(board,vis,i,0);
             }
          }
          for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!vis[i][j]){
                    board[i][j]='X';
                }
            }
            System.out.println();
          }
    }
}
