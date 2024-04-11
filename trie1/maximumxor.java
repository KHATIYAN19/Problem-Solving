class Solution {
    class TrieNode {
        TrieNode left;
        TrieNode right;
        public TrieNode() {
            left = null;
            right = null;
        }
    }
    TrieNode root =new TrieNode();
    public void insert( int num) {
        TrieNode curr = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (num>>i) & 1;
            if(bit == 0) {
                if(curr.left == null) {
                    curr.left = new TrieNode();
                }
                curr = curr.left;
            } else {
                if(curr.right == null) {
                    curr.right = new TrieNode(); 
                }
                curr = curr.right;
            }
        }
    }
    
    public int getMaxXor(int num) {
        TrieNode curr = root;
        int maxXor = 0;
        for(int i = 31; i >= 0; i--) {
            int bit = (num>>i) & 1;
            if(bit == 0) {
                if(curr.right != null) {
                    curr =  curr.right;
                    maxXor += (1<<i);
                } else {
                    curr = curr.left;
                }
            } else {
                if(curr.left != null) {
                    curr = curr.left;
                    maxXor += (1<<i);   //pow(2,i)
                } else {
                    curr = curr.right;
                }
            }
        }  
        return maxXor;
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int maxXor = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++) {
            insert(nums[i]);
        }
        for(int i=0;i<nums.length;i++) {
            maxXor = Math.max(maxXor, getMaxXor(nums[i]));
        }   
        return maxXor;
    }
}
