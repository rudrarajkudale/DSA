package Hashing;

import java.util.HashMap;

public class LargestSubarrWith0sum {
    public static void main(String[] args) {
        int arr[] = {15,-2,2,-8,1,7,10};
        HashMap<Integer, Integer> hm = new HashMap<>();

        int sum = 0, len = 0;
        for(int j=0; j<arr.length; j++){
            sum += arr[j];
            if(hm.containsKey(sum)){
                len = j - hm.get(sum);
            }
            else{
                hm.put(sum, j);
            }
        }

        System.out.println("The maximum subarray length is: " + len);
    }
}
