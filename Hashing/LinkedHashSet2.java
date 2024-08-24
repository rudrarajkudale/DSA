package Hashing;

import java.util.LinkedHashSet;

//It  stores elements in order
public class LinkedHashSet2 {
    public static void main(String[] args) {
        LinkedHashSet<Integer> hs = new LinkedHashSet<>();

        hs.add(1);
        hs.add(3);
        hs.add(2);
        hs.add(0);

        for(Integer num : hs){
            System.out.print(num + " ");
        }
    }
}
