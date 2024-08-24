package Trie;

public class WordBreakProblem {
    static class Node{
        Node children[] = new Node[26];
        boolean eow;
        Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        } 
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int ch = word.charAt(i) - 'a';
            if(curr.children[ch] == null){
                curr.children[ch] = new Node();
            }
            curr = curr.children[ch];
        }
        curr.eow = true;
    }

    public static boolean search(String key){
        Node curr = root;
        for(int i=0; i<key.length(); i++){
            int ch = key.charAt(i) - 'a';
            if(curr.children[ch] == null){
                return false;
            }
            curr = curr.children[ch];
        }
        return curr.eow;
    }

    //noe check for wordbreak
    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }

        for(int i=1; i<=key.length(); i++){
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("ilikesung"));
    }
}
