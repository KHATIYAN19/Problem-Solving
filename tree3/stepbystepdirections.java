class Solution {
    public  TreeNode lca(TreeNode root,int a,int b){
        if(root==null||root.val==a||root.val==b){
            return root;
        }
        TreeNode leftlca=lca(root.left,a,b);
        TreeNode rightlca=lca(root.right,a,b);
        if(rightlca==null){
            return leftlca;
        }
        if(leftlca==null){
            return rightlca;
        }
        return root;
    }
    public boolean leftpart(StringBuilder str,TreeNode root,int s){
        if(root==null){
            return false;
        }
        if(root.val==s){
            return true;
        }
        str.append('U');
        if(leftpart(str,root.left,s)||leftpart(str,root.right,s)){
            return true;
        }
        str.deleteCharAt(str.length()-1);
        return false;
    }
    public boolean rightpart(StringBuilder str,TreeNode root,int d){
        if(root==null){
            return false;
        }
        if(root.val==d){
            return true;
        }
            boolean leftans=root.left==null?rightpart(str,root.left,d):rightpart(str.append('L'),root.left,d);
            boolean rightans=root.right==null?rightpart(str,root.right,d):rightpart(str.append('R'),root.right,d);
        if(leftans||rightans){
            return true;
        }
        str.deleteCharAt(str.length()-1);
        return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca=lca(root,startValue,destValue);
        StringBuilder left=new StringBuilder("");
        StringBuilder right=new StringBuilder("");

        leftpart(left,lca,startValue);
        rightpart(right,lca,destValue);
        left.append(right);
         return left.toString();
    }
}
