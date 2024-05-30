class Solution {
    public int maxProduct(int[] nums) {
        int prod=1;
        int  maxprod=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            prod*=nums[i];
            maxprod=Math.max(prod,maxprod);
            if(prod==0){
                prod=1;
            }
        }
        prod=1;
         for(int i=nums.length-1;i>=0;i--){
            prod*=nums[i];
            maxprod=Math.max(prod,maxprod);
            if(prod==0){
                prod=1;
            }
        }
        return maxprod;
    }
}
