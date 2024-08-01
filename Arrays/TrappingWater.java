package Arrays;

public class TrappingWater {
    public static int trappingWater(int arr[], int n){

        //first find the left max poll for each poll
        int left[] = new int[n];
        left[0] = arr[0];
        for(int i=1; i<n; i++){
            left[i] = Math.max(left[i-1], arr[i]);
        }

        //first find the right max poll for each poll
        int right[] = new int[n];
        right[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            right[i] = Math.max(right[i+1], arr[i]);
        }

        //now find the trapped water
        int trapWater = 0;
        for(int i=0; i<n; i++){
            int waterlevel = Math.min(left[i], right[i]);
            trapWater += waterlevel - arr[i];
        }
        return trapWater;
    }
    public static void main(String[] args) {
        int arr[] = {4,2,0,6,3,2,5};
        System.out.println(trappingWater(arr, arr.length));
    }
}
