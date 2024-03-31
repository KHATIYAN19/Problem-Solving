class Solution {
    public int helper(TreeNode root, int low, int high){
        if(root==null){
            return 0;
        } 
        if(root.val>=low&&root.val<=high){
            return root.val+helper(root.left,low,high)+helper(root.right,low,high);
        }else{
             return helper(root.left,low,high)+helper(root.right,low,high);
        }

    }
    public int rangeSumBST(TreeNode root, int low, int high) {
       return helper(root,low,high);
    }
}
