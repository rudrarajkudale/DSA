package Hashing;

import java.util.TreeSet;

//It sorts the HashSet
public class TreeSet2 {
    public static void main(String[] args) {
        TreeSet<Integer> hs = new TreeSet<>();

        hs.add(1);
        hs.add(3);
        hs.add(2);
        hs.add(0);

        for(Integer num : hs){
            System.out.print(num + " ");
        }
    }
}
