package Hashing;

import java.util.HashSet;

//we have to count how many distinct element in array
public class CountDistinctEle {
    public static void main(String[] args) {
        int num[] = {4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<num.length; i++){
            hs.add(num[i]);
        }

        System.out.println(hs);
        System.out.println(hs.size());
    }
}
