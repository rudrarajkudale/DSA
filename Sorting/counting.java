package Sorting;

public class counting {
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void countingSort(int arr[]){
        int n = arr.length;
        
        //find maximum number to create count array
        int maxNum = arr[0];
        for(int i=1; i<n; i++){
            maxNum = Math.max(maxNum, arr[i]);
        }

        //now create count array and increase count as element repeated
        int count[] = new int[maxNum + 1];
        for(int i=0; i<n; i++){
            int curr  = arr[i];
            count[curr]++;
            }

        //now sort an array
        int j = 0;
        for(int i=0; i<=maxNum; i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
        printArray(arr);
    }

    public static void main(String[] args){
        int arr[] = {2,4,6,3,2,1};
        countingSort(arr);
    }
}

