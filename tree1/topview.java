class Solution
{
    static class Info{
        Node node;
        
        int hd;
        public Info(Node node,int hd){
            this.hd=hd;
            this.node=node;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        int min=0;
        int max=0;
        Queue<Info>q=new LinkedList<>();
        HashMap<Integer,Node>hm=new HashMap<>();
        q.add(new Info(root,0));
        q.add(null);
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!hm.containsKey(curr.hd)){
                    hm.put(curr.hd,curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min=Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max=Math.max(max,curr.hd+1);
                }
            }
        }
        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=min;i<=max;i++){
            arr.add(hm.get(i).data);
        }
        return arr;
    }
}
