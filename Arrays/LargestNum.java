package Arrays;

public class LargestNum {
    public static int largestNum(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int arr[] = {3,1,5,8,2,4,5};
        System.out.println(largestNum(arr));
    }
}
