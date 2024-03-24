class Solution {
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftd=diameterOfBinaryTree(root.left);
        int rightd=diameterOfBinaryTree(root.right);
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(Math.max(leftd,rightd),lh+rh);
    }
}
