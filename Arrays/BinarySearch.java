package Arrays;

public class BinarySearch {
    public static int binarySearch(int arr[], int key){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(key == arr[mid]){
                return mid;
            }
            if(key > arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,6,7,9,10,14};
        System.out.println(binarySearch(arr, 9));
    }
}
