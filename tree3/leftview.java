public class Solution {
    public static void helper(TreeNode<Integer>root,int level,ArrayList<Integer>arr){
        if(root==null){
            return;
        }
        if(arr.size()<level){
            arr.add(root.data);
        }
        helper(root.left, level+1, arr);
        helper(root.right, level+1, arr);
    }
    public static void printLeftView(TreeNode<Integer> root) {
       ArrayList<Integer>arr=new ArrayList<>();
       helper(root, 1, arr);
       for(int i=0;i<arr.size();i++){
           System.out.print(arr.get(i)+" ");
       }
    }
}
