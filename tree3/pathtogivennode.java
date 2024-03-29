
public class Solution {
    public static boolean helper(TreeNode A,int b,ArrayList<Integer>temp){
        if(A==null){
            return false;
        }
        temp.add(A.val);
        if(A.val==b){
            return true;
        }
        if(helper(A.left,b,temp)||helper(A.right,b,temp)){
            return true;
        }
        temp.remove(temp.size()-1);
        return false;
        
    }
    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer>arr=new ArrayList<>();
        helper(A,B,arr);
        int ans[]=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}
