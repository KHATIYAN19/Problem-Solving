class Solution{
    public int NthRoot(int n, int m){
        int s=1;
        int e=m;
        int ans=-1;
        while(s<=e) {
            int mid=(s+e)/2;
            int power=(int)Math.pow(mid,n);
            if(cal==m){
                 ans=mid;
            } 
            if(power<m){
                 s=mid+1;
            }else{
                 e=mid-1;
            }   
        }
        return ans;
    }
}
