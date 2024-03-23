public class Solution {
    public static int heightOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lh=heightOfBinaryTree(root.left);
        int rh=heightOfBinaryTree(root.right);
        return Math.max(lh,rh)+1;
    }
}
