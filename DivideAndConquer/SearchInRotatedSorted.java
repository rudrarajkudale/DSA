package DivideAndConquer;
//The rotated sorted array is rotated from the pivot so we have to find the key in
// minimum time complexity
//all elements are distinct amd sorted i ascending order
public class SearchInRotatedSorted {
    public static int indexfind(int arr[], int key, int si, int ei){
        if(si > ei){
            return -1;
        }

        int mid = si + (ei - si)/2;
        if(arr[mid] == key){
            return mid;
        }

        if(arr[si] <= arr[mid]){
            if(arr[si] <= key && arr[mid] >= key){
                return indexfind(arr, key, si, mid-1);
            } 
            else{
                return indexfind(arr, key, mid+1, ei);
            }
        }
        else{
            if(arr[mid+1] <= key && arr[ei] >= key){
                return indexfind(arr, key, mid+1, ei);
            }
            else{
                return indexfind(arr, key, si, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        System.out.println(indexfind(arr,0, 0, arr.length-1));
    }
}
