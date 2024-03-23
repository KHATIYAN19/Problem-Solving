class Solution {
    public  boolean isidentical(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        
        if(p==null||q==null||p.val!=q.val){
            return false;
        }

        return isidentical(p.left,q.left)&&isidentical(p.right,q.right);
        
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isidentical(p,q);
    } 
}
