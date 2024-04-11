import java.util.*;
class TrieNode{ 
    TrieNode children[];
    boolean isEnd;
    List<String> commonPrefixNames;
    TrieNode(){
    children = new TrieNode[26];
    isEnd = false;
    commonPrefixNames = new ArrayList<>();
    }
}
public class a {
    public static void insertIntoTrie(TrieNode root, String name){
        TrieNode node = root;
        for(int i=0; i<name.length(); i++){
        char currCharacter = name.charAt(i);
        if(node.children[currCharacter - 'a'] == null){ 
          node.children[currCharacter - 'a'] = new TrieNode();
        }
        node = node.children[currCharacter - 'a']; 
        node.commonPrefixNames.add(name); 
        }
        node.isEnd = true; 
    }
    private static void query(TrieNode root){
        TrieNode node = root;
        Scanner scanner = new Scanner(System.in);
        while(true){
        System.out.println("Enter a character");
        char input = scanner.next().charAt(0);
        if(node.children[input - 'a'] == null){
        System.out.println(-1);
        break;
        }
        node = node.children[input - 'a'];
        System.out.println(node.commonPrefixNames);
        System.out.println();
        }
        }
        public static void main(String args[]){
            String names[] = {"ishaan", "ishika", "ayush", "ayushman", "alok", "ayan", "ishika"};
            TrieNode root = new TrieNode();
            for(String name: names){ 
            insertIntoTrie(root, name);
            }
            query(root);
        }
}
