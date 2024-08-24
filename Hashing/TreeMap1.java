package Hashing;

import java.util.TreeMap;

//keys are stored in sorted manner
public class TreeMap1 {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();

        //Adding and replacing
        tm.put("Rudra", 100);
        tm.put("Amar", 99);
        tm.put("Akabar", 87);
        tm.put("Antheny", 35);

        //Get key
        System.out.println(tm);
    }
}
