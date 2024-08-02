package Sorting;

public class selection {
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void selectionSort(int arr[]){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            int minimum = i;
            for(int j=i+1; j<n; j++){
                if(arr[minimum]> arr[j]){
                    minimum = j;
                }
            }
            int temp = arr[minimum];
            arr[minimum] = arr[i];
            arr[i] = temp;
        }
        printArray(arr);
    }

    public static void main(String[] args){
        int arr[] = {2,4,6,3,2,1};
        selectionSort(arr);
    }
}
