class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int ans=-1;
        int left=0;
        
        int window=0;
        for(int right=0;right<t.length();right++){
            window+=Math.abs(s.charAt(right)-t.charAt(right));
            while(window>maxCost){
                 window-=Math.abs(s.charAt(left)-t.charAt(left));
                 left++;
            }
           ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}
