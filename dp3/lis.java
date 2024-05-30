class Solution {

    //tab
     public int tab(int nums[]){
        int dp[]=new int[nums.length];
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            int m=0;
            for(int j=0;j<=i-1;j++){
                if(nums[j]<nums[i]){
                  m=Math.max(dp[j],m);
                }
            }
            dp[i]=m+1;
        }
        int ans=0;
        for(int i=0;i<dp.length;i++){
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }


  //binary search
    public int lowerBound(ArrayList<Integer> nums,int target){
        int start = 0;
        int end = nums.size()-1;
        int index = 0;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums.get(mid) == target){
                return mid;
            }
            else if(nums.get(mid)>target){
                index = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return index;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for(int i=1;i<n;i++){
           if(nums[i]>arr.get(arr.size()-1)){
               arr.add(nums[i]);
           }
           else {
               int ind = lowerBound(arr,nums[i]);
               arr.set(ind,nums[i]);
           }
        }
        return arr.size();
    }
}
