package Trie;

//Create , Insert and Search in a Trie
public class CreatingTrie {

    //create a node which consists array of for all letters
    //and a varibale which tells the word is ended or not
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    //create a function to insert a word in the trie
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
    
    //search in Trie    
    public static boolean search(String key){
        Node curr = root;
        for(int i=0; i<key.length(); i++){
            int ch = key.charAt(i) - 'a';
            if(curr.children[ch] == null){
                return false;
            }
            else{
                curr = curr.children[ch];
            }
        }
        return curr.eow;
    }
    public static void main(String[] args) {

        String words[] = {"the", "a", "there", "their", "any", "thee"};
        //insert word by word
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }
    
        System.out.println(search("thee"));
        System.out.println(search("an"));
    }
}
