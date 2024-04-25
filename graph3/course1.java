class Solution {
    public void caldegree(int [][]pre,int degree[]){
        for(int i=0;i<pre.length;i++){
            degree[pre[i][1]]++;
        }
    }
    public  boolean topo(int [][]pre,int n){
        int degree[]=new int[n];
        caldegree(pre,degree);
        for(int i=0;i<pre.length;i++){
            System.out.print(degree[i]+" ");
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<pre.length;i++){
            if(degree[i]==0){
                q.add(i);
            }
        }
        System.out.println(q);
        while(!q.isEmpty()){
            int curr=q.remove();
            for(int i=0;i<n-1;i++){
                if(pre[i][0]==curr){
                    degree[pre[i][1]]--;
                    if(degree[pre[i][1]]==0){
                          q.add(pre[i][1]);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(degree[i]!=0){
                return false;
            }
        }
        return true;
    }
    public boolean canFinish(int n, int[][] pre) {
        return topo(pre,n);
    }
}
