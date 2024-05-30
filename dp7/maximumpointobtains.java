class Solution {
    public int maxScore(int[] arr, int k) {
        int maxpoint=0;
        int leftsum=0;
        int rightsum=0;
        for(int i=0;i<k;i++){
            leftsum+=arr[i];
        }
        maxpoint=leftsum;
        int j=arr.length-1;
        for(int i=k-1;i>=0;i--){
            leftsum-=arr[i];
            rightsum+=arr[j];
            j--;
            maxpoint=Math.max(maxpoint,leftsum+rightsum);
        }
        return maxpoint;
    }
}
