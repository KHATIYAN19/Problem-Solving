import java.util.*;
class Solution {
    public static class Info {
        TreeNode node;
        int hd;
        Info(TreeNode node, int hd) {
            this.hd = hd;
            this.node = node;
        }
    }
    public static void vertical(TreeNode root, List<List<Integer>> ans) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int min = 0;
        int max = 0;
        q.add(new Info(root, 0));
        q.add(null);
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                hm.putIfAbsent(curr.hd, new ArrayList<Integer>());
                hm.get(curr.hd).add(curr.node.val);
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            List<Integer> tempp = hm.get(i);
            ans.add(new ArrayList<>(tempp));
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        vertical(root, ans);
        return ans;
    }
}
