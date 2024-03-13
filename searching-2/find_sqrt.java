class Solution {
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        int ans=1;
        int s=1;
        int e=x;
        while(s<=e){
            int mid=s+(e-s)/2;
            if((long)mid*mid<=(long)x){
                ans=mid; 
                s=mid+1;
            }
           else{
                
                e=mid-1;
            }
        }
        return ans;
    }
}
