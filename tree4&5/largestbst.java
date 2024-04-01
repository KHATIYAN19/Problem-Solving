class Solution{
    public static class Info{
        boolean isbst;
        int size;
        int min;
        int max;
        Info(boolean isbst,int size,int min,int max){
            this.isbst=isbst;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static Info helper(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftinfo=helper(root.left);
        Info rightinfo=helper(root.right);
        int min=Math.min(root.data,leftinfo.min);
        int max=Math.max(root.data,rightinfo.max);
        boolean isbst=leftinfo.isbst&&rightinfo.isbst&&root.data<rightinfo.min&&root.data>leftinfo.max;
        int size=0;
        if(isbst){
          size=leftinfo.size+rightinfo.size+1;
        }else{
            size=Math.max(leftinfo.size,rightinfo.size);
        }
        return new Info(isbst,size,min,max);
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
       return helper(root).size;
        
    }
}
