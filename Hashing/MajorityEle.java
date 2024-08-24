package Hashing;

import java.util.*;

public class MajorityEle {
    public static void main(String[] args) {
        int arr[] = {1,3,5,5,1,3,1,5,1};

        HashMap<Integer, Integer> hm = new HashMap<>();
        
        //store number and count 
        //if number repear then increase count
        for(int i = 0; i<arr.length; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 1) + 1);
        }

        //print keys which appear mpre than n/3 
        for(int key : hm.keySet()){
            if(hm.get(key) > arr.length/3){
                System.out.println(key);
            }
        }
    }
}
