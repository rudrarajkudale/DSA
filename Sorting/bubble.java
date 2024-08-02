package Sorting;

public class bubble {
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int arr[]){
        int n = arr.length;

        //check array is already sorted or not
        boolean sorted = true;
        for(int i=0; i<n-1; i++){
            if(arr[i] > arr[i+1]){
                sorted = false;
            }
        }
        if(sorted == true){
            System.out.println("Array is already sorted");
            return;
        }

        //bubble sorting by swapping largest to the end
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        printArray(arr);
    }

    public static void main(String[] args){
        int arr[] = {2,4,6,3,2,1};
        bubbleSort(arr);
    }
}
