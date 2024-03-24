class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int ans = root.val;
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    ans = q.peek().val;
                    q.add(null);
                }
            } else {
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
     return ans;
    }
}
