class TrieNode {
    TrieNode[] children;
    int freq;
    public TrieNode() {
        children = new TrieNode[26];
        freq=1;
    }
}
class Solution {
    TrieNode root=new TrieNode();
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int idx=ch-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }else{
                curr.children[idx].freq++;
            }
            curr=curr.children[idx];
        }
    }
    public  int sum(String s){
         int sum=0;
         TrieNode curr=root;
         for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int idx=ch-'a';
            sum+=curr.children[idx].freq;
             curr=curr.children[idx];
         }
         return sum;
    }
    public int[] sumPrefixScores(String[] words) {
       for(int i=0;i<words.length;i++){
          insert(words[i]);
       }
       int ans[]=new int[words.length];
       for(int i=0;i<ans.length;i++){
          ans[i]=sum(words[i]);
       }
       return ans;
    }
}
