package Hashing;

import java.util.*;

public class HashSetOperations {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);

        System.out.println(hs.contains(2));
        System.out.println(hs.size());
        System.out.println(hs.remove(3));
        hs.clear();
        System.out.println(hs.isEmpty());
    }
}
