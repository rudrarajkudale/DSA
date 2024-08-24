package Hashing;

import java.util.HashMap;

public class SubarraySumEqualK {
    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;

        //store sum and count in hashmap
        HashMap<Integer, Integer> hm = new HashMap<>(); 

        //put sum 0 and count 1 in hashmap
        //cause whenever we get while subarray withount - i then it will be 0
        hm.put(0, 1);

        //initize sum and ans
        int sum=0, ans=0;
        for(int j=0; j<arr.length; j++){
            sum += arr[j];
            //if sum-k present in hashmap just increase count 
            if(hm.containsKey(sum-k)){
                ans += hm.get(sum-k);
            }else{
                // or put value in hashmap if already exists then increase count
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }
        System.out.println("The total subarrays are: " + ans);
    }
}
