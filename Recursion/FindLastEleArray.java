package Recursion;

public class FindLastEleArray {
    public static int findElement(int arr[], int key, int i){
        if(i == arr.length){
            return -1;
        }
        int isFound = findElement(arr, key, i+1);
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,2,1,4,6,7,3};
        System.out.println(findElement(arr, 6, 0));
    }
}
