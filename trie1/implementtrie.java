class TrieNode {
    boolean eow;
    TrieNode[] children;
    
    public TrieNode() {
        eow = false;
        children = new TrieNode[26];
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
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
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int idx=ch-'a';
            if(curr.children[idx]==null){
                return false;
            }
             curr=curr.children[idx];
        }
        return curr.eow==true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            int idx=ch-'a';
            if(curr.children[idx]==null){
                return false;
            }
             curr=curr.children[idx];
        }
        return true;
    }
}
