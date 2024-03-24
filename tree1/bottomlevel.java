

//User function Template for Java


class Solution
{
    class Info{
        int hd;
        Node node;
        Info(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer>ans=new ArrayList<>();
        Queue<Info>q=new LinkedList<>();
        HashMap<Integer,Node>hm=new HashMap<>();
        q.add(new Info(root,0));
        int min=0;
        int max=0;
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr==null){
              if(q.isEmpty()){
                break;
              }else{
                q.remove(null);
              }
            }else{
                hm.put(curr.hd,curr.node);
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
        for(int i=min;i<=max;i++){
            ans.add(hm.get(i).data);
        }
        return ans;
    }
}
