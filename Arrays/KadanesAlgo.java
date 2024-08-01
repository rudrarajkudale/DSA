package Arrays;

public class KadanesAlgo {
    public static int kadanes(int arr[]){
        int n = Integer.MIN_VALUE;
        //if all numbers are negative then just pick up largest
        for(int i=0; i<arr.length; i++){
            if(n < arr[i]){
                n = arr[i];
            }
        }
        if(n < 0){
            return n;
        }

        //otherwise find by kadanes algorithm
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0; i<arr.length; i++){
            currSum += arr[i];
            if(currSum < 0){
                currSum = 0;
            }
            if(currSum > maxSum){
                maxSum = currSum;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(kadanes(arr));
    }
}  
