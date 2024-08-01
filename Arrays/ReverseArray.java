package Arrays;

public class ReverseArray {
    // public static void  reverseArray(int arr[]){
    //     if(arr.length == 0){
    //         return;
    //     }
    //     int n = arr.length;
    //     for(int i=0; i<n/2; i++){
    //         int temp = arr[i];
    //         arr[i] = arr[n-i-1];
    //         arr[n-i-1] = temp;
    //     }
    // }

    public static void  reverseArray(int arr[]){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        reverseArray(arr);
        printArray(arr);
    }
}
