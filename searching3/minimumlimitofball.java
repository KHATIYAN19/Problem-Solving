class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low= 0;
        int high = 1000000000;
        while (low +1< high) {
            int mid = (high - low)/2 + low;
            int count = 0;
            
            for (int a: nums) {
                count+=(a-1)/mid;
            }
            
            if (count <= maxOperations) {
                high= mid;
            } else {
                low = mid;
            }
        }
        return high;
    }
}
