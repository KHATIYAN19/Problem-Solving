class Solution
{
    public long tab(int n){
       if(n==1||n==0){
           return 1;
       }
       int m = 1000000007;
       long prev=1;
       long curr=1;
       long ne=curr;
       for(int i=2;i<n+1;i++){
            ne=(curr%m+((i-1)*prev)%m)%m;
            prev=curr;
            curr=ne;
       }
       return curr;
    }
    public long countFriendsPairings(int n) 
    {  
        return tab(n);
    }
}    
 
