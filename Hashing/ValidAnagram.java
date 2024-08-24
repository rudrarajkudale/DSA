package Hashing;

import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        //store letter and frequency in hashmap
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            if(hm.containsKey(ch)){
                if(hm.get(ch) == 1){
                    hm.remove(ch);
                }else{
                    hm.put(ch, hm.get(ch)-1);
                }
            }
            else{
                return false;
            }
        }
        return hm.isEmpty();
    }
    public static void main(String[] args) {
        String s = "keeen";
        String t = "kneee";

        System.out.println(isAnagram(s,t));

    }
}
