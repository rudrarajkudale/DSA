package Array2D;

public class FindNum {
    public static void findNum(int arr[][], int key){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == key){
                    System.out.println("The key at index: " + i +  "," + j);
                    return;
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        findNum(arr, 5);
    }
}
