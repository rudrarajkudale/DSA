package Arrays;
//this is more Optimized way 

public class PrefixSum {
    public static int prefixSum(int arr[]){
        int n = arr.length;
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
                int currSum = 0; 
            for(int j=i; j<n; j++){
                currSum = i==0 ? prefix[j] : prefix[j] - prefix[i-1];
            }
            if(currSum > maxSum){
                maxSum = currSum;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(prefixSum(arr));
    }
}
