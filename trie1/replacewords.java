 
    class TrieNode {
    TrieNode[] children; 
    boolean eow;  
    public TrieNode() {
        children = new TrieNode[26];
        eow=false;
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
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public String prefixfind(String s) {
        TrieNode curr = root;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                break;
            }
            ans.append(s.charAt(i));
            curr = curr.children[idx];
            if (curr.eow) {
                return ans.toString();
            }
        }
        return s;
    } 
    public String replaceWords(List<String> dictionary, String sentence) {
        String arr[]=sentence.split(" ");
        String ans="";
        for(int i=0;i<dictionary.size();i++){
            insert(dictionary.get(i));
        }
        for(int i=0;i<arr.length;i++){
            String temp=prefixfind(arr[i]);
            ans+=temp;
            ans+=" ";
        }
        return ans.trim();
    }
}
