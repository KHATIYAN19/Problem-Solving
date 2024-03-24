class Solution {
    public static void helper(TreeNode root, List<String> ans, String temp) {
        temp += root.val;
        if (root.left == null && root.right == null) {
            ans.add(temp);
            return;
        }
        temp += "->";
        if (root.left != null) {
            helper(root.left, ans, temp);
        }
        if (root.right != null) {
            helper(root.right, ans, temp);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root, ans, "");
        return ans;
    }
}
