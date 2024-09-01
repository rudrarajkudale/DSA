package DynamicProgramming;

public class MinimumPartition {
    public static int minimumPartitioning(int arr[]){
        int n = arr.length;

        //find sum
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }

        //decide sum to create matrix of half sum
        int W = sum/2;
        //create matrix
        int dp[][] = new int[n+1][W+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int i=0; i<=W; i++){
            dp[0][i] = 0;
        }

        //now perform 0-1 knapsack to fill it
        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){
                int w = arr[i-1];
                if(w <= j){
                    dp[i][j] = Math.max(w + dp[i-1][j-w], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        //now subtraction
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum2 - sum1);
    }
    public static void main(String[] args){
        int arr[] = {1,6,11,5};
        System.out.println(minimumPartitioning(arr));
    }
}
