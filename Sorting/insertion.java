package Sorting;

public class insertion {
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertionSort(int arr[]){
        int n = arr.length;

        for(int i=0; i<n; i++){
            int curr  = arr[i];
            int prev = i-1;
            while(prev >= 0 && arr[prev] > curr){
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
        printArray(arr);
    }

    public static void main(String[] args){
        int arr[] = {2,4,6,3,2,1};
        insertionSort(arr);
    }
}

