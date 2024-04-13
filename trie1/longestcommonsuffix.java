  
import java.util.*;

class TrieNode {
    TrieNode[] children;
    int idx;

    public TrieNode(int idx) {
        idx = idx;
        children = new TrieNode[26];
    }
}
class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode(0);
        int n = wordsContainer.length;
        for (int i = 0; i < n; i++) {
            String word = wordsContainer[i];
            if (wordsContainer[root.idx].length() > word.length()) {
                root.idx= i;
            }
            TrieNode curr = root;
            for (int j = word.length() - 1; j >= 0; j--) {
                int c = word.charAt(j) - 'a';
                if (curr.children[c] == null) {
                    curr.children[c] = new TrieNode(i);
                }
                curr = curr.children[c];
                if (wordsContainer[curr.idx].length() > word.length()) {
                    curr.idx = i;
                }
            }
        }
        int [] ans = new int [wordsQuery.length];
        int k=0;
        for (String word : wordsQuery) {
            TrieNode curr = root;
            for (int j = word.length() - 1; j >= 0; j--) {
                int c = word.charAt(j) - 'a';
                if (curr.children[c] == null) {
                    break;
                }
                curr = curr.children[c];
            }
            ans[k]=curr.idx;
            k++;
        }
        return ans;
    }
}

