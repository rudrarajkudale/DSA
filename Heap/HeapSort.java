package Heap;

//sort in scending order
public class HeapSort {
    public static void heapify(int arr[], int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int max = i;

        if(left < size && arr[left] > arr[max]){
            max = left;
        }

        if(right < size && arr[right] > arr[max]){
            max = right;
        }

        if(max != i){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            heapify(arr, max, size);
        }
    }
    public static void heapSort(int arr[]){
        //build maxheap
        int n = arr.length;

        //heapify to the last level so we find max of that level
        for(int i=n/2; i>=0; i--){
            heapify(arr, i, n);
        }

        //now replace that max with root node
        for(int i = n-1; i>0; i--){
            //swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            //and again call heapify for root node 
            //with less size so exclude max element to last
            heapify(arr, 0, i);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,3};
        heapSort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
