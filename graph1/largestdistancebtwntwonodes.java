
public class Solution { 
    int ans=0;
    public int solve(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int N=A.size();
        if(N==1){
        return 0;
        }
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<Integer>());
        }
        int root=0;
        for(int i=0;i<A.size();i++){
            if(A.get(i) ==-1){
                root=i;
                 continue;
            }
            adj.get(A.get(i)).add(i);
        }
        ans=0;
        int dist[]=new int[N];
        Arrays.fill(dist,-1);
        helper(adj,dist,root);
        return ans-1;
    }
    public int helper(ArrayList<ArrayList<Integer>> adj,int dist[],int root){
        if(dist[root]!=-1)
        return dist[root];
        int max1=0,max2=0;
        for(int i : adj.get(root){
            int height = find(adj,dist,i);
            if(height>=max1){
                max2=max1;
                max1=height;
            } else if(height>max2){
                max2=height;
            }
        }
        ans=Math.max(ans,max1+max2+1);
        dist[root]=max1+1;
        return max1+1;
    }
}
