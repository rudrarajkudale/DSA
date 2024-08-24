package Hashing;

import java.util.ArrayList;
import java.util.HashSet;

// Return the Union and Intersection of the arrays
public class UnionIntersection {
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        //Union
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            hs.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            hs.add(arr2[i]);
        }
        System.out.println("Union is : " + hs);

        //Intersection
        hs = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            hs.add(arr1[i]);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<arr2.length; i++){
            if(hs.contains(arr2[i])){
                arr.add(arr2[i]);
                hs.remove(arr2[i]);
            }
        }
        System.out.println("Union is : " + arr);
    }
}
