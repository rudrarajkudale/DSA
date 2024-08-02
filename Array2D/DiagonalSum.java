package Array2D;

public class DiagonalSum {

    // This is not an optimal solution
    // public static int diagonalSum(int arr[][]){
    //     int sum = 0;
    //     int n = arr.length;
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<n; j++){
    //             if(i == j){
    //                 if(n % 2 == 1 && i == n/2){
    //                     sum += 0;
    //                 }
    //                 else{
    //                     sum += arr[i][j];
    //                 }
    //             }
    //             if(i + j == n-1){
    //                 sum += arr[i][j];
    //             }
    //         }
    //     }
    //     return sum;
    // }

    //optimal Solution is :
    public static int diagonalSum(int arr[][]){
        int sum = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            sum += arr[i][i];
            if(i != n-1-i)
            sum += arr[i][n-1-i];
        }
        return sum;
     }
        
    public static void main(String[] args) {
        int arr[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(diagonalSum(arr));
    }
}
