class GfG {
    public  Node lca(Node root,int a,int b){
        if(root==null||root.data==a||root.data==b){
            return root;
        }
        Node leftlca=lca(root.left,a,b);
        Node rightlca=lca(root.right,a,b);
        if(rightlca==null){
            return leftlca;
        }
        if(leftlca==null){
            return rightlca;
        }
        return root;
    }
    public  int dist(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftdis=dist(root.left,n);
        int rightdis=dist(root.right,n);
        if(leftdis==-1&&rightdis==-1){
            return -1;
        }
        else if(leftdis==-1){
            return rightdis+1;
        }else{
            return leftdis+1;
        }
    }
    int findDist(Node root, int a, int b) {
        Node lca=lca(root,a,b);
        int d1=dist(lca,a);
        int d2=dist(lca,b);
        return d1+d2;
    }
}
