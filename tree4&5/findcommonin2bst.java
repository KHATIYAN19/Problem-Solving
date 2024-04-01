
class Solution
{
    public static void insertinset(Node root,HashSet<Integer>s){
        if(root==null){
            return;
        }
        s.add(root.data);
        insertinset(root.left,s);
        insertinset(root.right,s);
    }
    public static void findallcommon(Node root,HashSet<Integer>s,ArrayList<Integer>arr){
        if(root==null){
            return;
        }
        findallcommon(root.left,s,arr);
        if(s.contains(root.data)){
            arr.add(root.data);
        }
        findallcommon(root.right,s,arr);
    }
    //Function to find the nodes that are common in both BST.
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        HashSet<Integer>s=new HashSet<Integer>();
        ArrayList<Integer>ans=new ArrayList<>();
        insertinset(root1,s);
        findallcommon(root2,s,ans);
        return ans;
       
    }
}
