class Solution {
    int s=0;
    public TreeNode build(int []preorder,int maxvalue){
        if(s>=preorder.length||preorder[s]>maxvalue){
            return null;
        }
        TreeNode root=new TreeNode(preorder[s++]);
        root.left=build(preorder,root.val);
        root.right=build(preorder,maxvalue);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,Integer.MAX_VALUE);
    }
}
