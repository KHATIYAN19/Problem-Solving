class Solution {
     int count=0;
    public int  helper(TreeNode root,int k){
        if(root==null){
            return -1 ;
        }
        int left =helper(root.left,k);
        if(left!=-1){
            return left;
        }
       count++;
       if(count==k){
         return root.val;
       }
       int right=helper(root.right,k);
       return right;
    }
    public int kthSmallest(TreeNode root, int k) {
         return helper(root,k);
    }
}
