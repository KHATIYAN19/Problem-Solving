class Solution {
    public static void inorder(TreeNode root,List<Integer>arr){
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer>arr=new ArrayList<>();
        inorder(root,arr);
        int i=0;
        int j=arr.size()-1;
        while(i<j){
            if(arr.get(i)+arr.get(j)==k){
                return true;
            }else if(arr.get(i)+arr.get(j)>k){
                    j--;
            }else{
                   i++;
            }
        }
        return false;
    }
}
