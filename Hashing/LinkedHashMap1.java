package Hashing;

import java.util.LinkedHashMap;

//It stores the order of insertion and normal Hashmap not.
public class LinkedHashMap1 {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        //Adding and replacing
        lhm.put("Rudra", 100);
        lhm.put("Amar", 99);
        lhm.put("Akabar", 87);
        lhm.put("Antheny", 35);

        //Get key
        System.out.println(lhm);
    }
}
