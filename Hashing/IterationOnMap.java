package Hashing;
import java.util.HashMap;
import java.util.Set;


//It is Using by Set 
//In set we only store the keys
public class IterationOnMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        //Adding and replacing
        hm.put("Rudra", 100);
        hm.put("Amar", 99);
        hm.put("Akabar", 87);
        hm.put("Antheny", 35);

        Set<String> keys = hm.keySet();
        for(String key : keys){
            System.out.println("Key is: " + key + ", and value is: " + hm.get(key));
        }
    }
}
