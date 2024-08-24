package Trie;

public class PrefixProblem {
    static class Node{
        Node children[] = new Node[26];
        boolean eow;
        int freq;
        Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            freq = 1;
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
            else{
                curr.children[ch].freq++;
            }
            curr = curr.children[ch];
        }
        curr.eow = true;
    }

    public static String prefixProblem(String str){
        StringBuilder sb = new StringBuilder();
        Node curr = root;

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            sb.append(ch);
            int idx = ch - 'a';
            if(curr.children[idx].freq == 1){
                return sb.toString();
            }
            curr = curr.children[idx];
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String words[] = {"dog", "zebra", "dove", "duck"};
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        for(int i=0; i<words.length; i++){
            System.out.println(prefixProblem(words[i]));
        }
    }
}
