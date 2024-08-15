package ArrayList;

import java.util.ArrayList;

public class MaximumWater {
    // brute force approach
    // public static int maximumWater(ArrayList<Integer> arr){
    //     int max = Integer.MIN_VALUE;
    //     for(int i=0; i<arr.size(); i++){
    //         for(int j=i; j<arr.size(); j++){
    //             int h = Math.min(arr.get(i), arr.get(j));
    //             int w = j-i;
    //             int curr = h * w;
    //             max = Math.max(max, curr);
    //         }
    //     }
    //     return max;
    // }


    //Time Complexity - O(n)
    public static int maximumWater(ArrayList<Integer> arr){
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = arr.size()-1;
        while(right > left){
            int h = Math.min(arr.get(left), arr.get(right));
            int w = right - left;
            int curr = h * w;
            max = Math.max(max, curr);
            if(arr.get(right) < arr.get(left)){
                right--;
            }else{
                left++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(maximumWater(height));
    }
}
