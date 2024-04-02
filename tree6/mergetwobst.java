class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public void treetoarray(Node root,ArrayList<Integer>arr){
        if(root==null){
            return;
        }
        treetoarray(root.left,arr);
        arr.add(root.data);
        treetoarray(root.right,arr);
    }
    public List<Integer> merge(Node root1,Node root2)
    {
        ArrayList<Integer>a1=new ArrayList<>();
        ArrayList<Integer>a2=new ArrayList<>();
        treetoarray(root1,a1);
        treetoarray(root2,a2);
       ArrayList<Integer>arr=new ArrayList<>();
        int i=0;
        int j=0;
        int n = a1.size();
        int m = a2.size();
          while(i<n && j<m){
            if(a1.get(i)<a2.get(j)){
                arr.add(a1.get(i++));
            }else{
                arr.add(a2.get(j++));
            }
        }
        while(i<n){
        arr.add(a1.get(i++));
        }
        while(j<m){
            arr.add(a2.get(j++));
        }
       return arr;   
    }
}
