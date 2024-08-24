package Hashing;

import java.util.*;

//It is Using by EntrySet 
//In entry set we store the keys as well as values
public class IterationOnMap2 {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        //Adding and replacing
        hm.put("Rudra", 100);
        hm.put("Amar", 99);
        hm.put("Akabar", 87);
        hm.put("Antheny", 35);

        Set<Map.Entry<String, Integer>> entities = hm.entrySet();
        for(Map.Entry<String, Integer> entry : entities){
            System.out.println("Key is: " + entry.getKey() + ", and value is: " + entry.getValue());
        }
    }
}

