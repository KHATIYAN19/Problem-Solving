import java.util.*;
class Solution {
    public void helper(TreeNode root,List<List<Integer>>ans){
        if(root==null){
            return;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer>temp=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr=q.remove();
             if(curr==null){
                ans.add(new ArrayList<>(temp));
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    temp=new ArrayList<>();
                }
            }else{
                temp.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        helper(root,ans);
        return ans;
    }
}
