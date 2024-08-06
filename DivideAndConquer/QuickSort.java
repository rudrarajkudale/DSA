package DivideAndConquer;

public class QuickSort {
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int pivot = Pivot(arr, si, ei);
        quickSort(arr, si, pivot-1);
        quickSort(arr, pivot+1, ei);
    }

    public static int Pivot(int arr[], int si, int ei){
        int i = si-1;
        int pivot = arr[ei];
        for(int j=si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int arr[] = {3,5,6,2,3,1,2};
        quickSort(arr, 0, arr.length-1);
        printArray(arr);
    }
}
