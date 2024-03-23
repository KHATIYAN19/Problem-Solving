class Solution
{
	int getLevelDiff(Node root)
	{
	    int diff=0;
	    Queue<Node>q=new LinkedList<>();
	    q.add(root);
	    q.add(null);
	    boolean isodd=true;
	    while(!q.isEmpty()){
	        Node curr=q.remove();
	        if(curr==null){
	            if(q.isEmpty()){
	                break;
	            }else{
	                q.add(null);
	                isodd=!isodd;
	            }
	        }else{
	            diff=isodd?diff+curr.data:diff-curr.data;
	            if(curr.left!=null){
	                q.add(curr.left);
	            }
	            if(curr.right!=null){
	                q.add(curr.right);
	            }
	        }
	    }
	    
	   return diff;
	}
}
