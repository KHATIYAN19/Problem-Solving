class Solution {
    int count=0;
    ArrayList<Long>l=new ArrayList<>();
    public void helper(TreeNode root,int sum){
        if(root==null){
            return;
        }
        l.add((long)root.val);
        helper(root.left,sum);
        helper(root.right,sum);
        long temp=0;
        for(int i=l.size()-1;i>=0;i--){
            temp+=l.get(i);
            if(temp==sum){
                count++;
            }
        }
        l.remove(l.size()-1);
    }
    public int pathSum(TreeNode root, int targetSum) {
        helper(root,targetSum);
        return count;
    }
}
