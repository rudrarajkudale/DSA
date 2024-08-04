package Recursion;

public class FindElementArray {
    public static int findElement(int arr[], int key, int i){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return findElement(arr, key, i+1);
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,2,1,4,6,7,3};
        System.out.println(findElement(arr, 6, 0));
    }
}
