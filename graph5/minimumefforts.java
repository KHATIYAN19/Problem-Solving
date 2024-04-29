public class Info{
    int i;
    int j;
    int diff;
    Info(int i,int j,int diff){
        this.i=i;
        this.j=j;
        this.diff=diff;
    }
}
class Solution {
    final int dir[][]={
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=(int)(1e9);
            }
        }
       PriorityQueue<Info>pq=new PriorityQueue<>((a,b)->a.diff-b.diff);
       arr[0][0]=0;
       pq.add(new Info(0,0,0));
       while(!pq.isEmpty()){
         Info curr=pq.remove();
         int r=curr.i;
         int c=curr.j;
         int diff=curr.diff;
         if(r==n-1&&c==m-1){
            return diff;
         }
         for(int i=0;i<4;i++){
            int nr=r+dir[i][0];
            int nc=c+dir[i][1];
            if(nr>=0&&nc>=0&&nr<n&&nc<m){
                int effort=Math.max(Math.abs(heights[r][c]-heights[nr][nc]),diff);
                if(effort<arr[nr][nc]){
                    arr[nr][nc]=effort;
                    pq.add(new Info(nr,nc,effort));
                }
            }
         }
       }
      return 0;
    }
}
