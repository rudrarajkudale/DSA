package Hashing;
import java.util.HashMap;

//Keys are stored randomly
public class HashMapOperations {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        //Adding and replacing
        hm.put("Rudra", 100);
        hm.put("Amar", 99);
        hm.put("Akabar", 87);
        hm.put("Antheny", 35);

        //Get key
        System.out.println(hm.get("Rudra"));

        //check the key is present or not
        System.out.println(hm.containsKey("Anamol"));
        System.out.println(hm.containsKey("Akabar"));

        //remove key
        hm.remove("Akabar");

        //check size
        System.out.println(hm.size());

        //clear all the keys from hasmap
        hm.clear();

        //check hashmap is empty or not
        System.out.println(hm.isEmpty());
    }
}
