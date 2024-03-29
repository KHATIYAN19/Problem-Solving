class Solution {
    public static void helper(TreeNode root,int sum,List<List<Integer>>ans,List<Integer>temp){
      if(root==null){
        return;
      }
       temp.add(root.val);
       if(root.left==null&&root.right==null&&sum-root.val==0){
        ans.add(new ArrayList<>(temp));
       }else{
       helper(root.left,sum-root.val,ans,temp);
       helper(root.right,sum-root.val,ans,temp);
       }
       temp.remove(temp.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        helper(root,targetSum,ans,temp);
        return ans;
    }
}
