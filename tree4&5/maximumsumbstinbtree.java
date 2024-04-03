class Solution {
    class Info {
    public int max;
    public int min;
    public int sum;
    public Info(int min, int max, int sum) {
        this.max = max;
        this.min = min;
        this.sum = sum;
    }
   }
    int ans = Integer.MIN_VALUE;
    public Info helper(TreeNode root) {
        if (root == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Info l = helper(root.left);
        Info r = helper(root.right);
        if (l.max < root.val && root.val < r.min) {
            int sum=l.sum + r.sum + root.val;
            ans = Math.max(ans,sum);
            int min=Math.min(root.val, l.min);
            int max= Math.max(root.val, r.max);
            return new Info(min,max,sum);
        }
        return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans > 0 ? ans : 0;
    }
}
