package Arrays;
//also finding maxsum here but not optimized way

public class SubarraysMaxsum1 {
    public static void subarraysSum(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int currSum = 0;
                for(int k=i; k<=j; k++){
                    currSum += arr[k];
                }
                System.out.print("("+ currSum + ")");
                if(currSum > maxSum){
                    maxSum = currSum;
                }
            }
            System.out.println();
        }
    System.out.println("The maximum sum is:" + maxSum); 
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        subarraysSum(arr);
    }
}

