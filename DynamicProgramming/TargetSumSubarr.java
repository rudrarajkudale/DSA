package DynamicProgramming;

public class TargetSumSubarr {
    //Lets do with Tabulation
    //same as snapsack 01
    public static boolean targetSum(int val[], int sum){
        int n = val.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i=0; i<=n; i++){
            dp[i][0] = true;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                int v = val[i-1];
                
                if(v <= j){
                    boolean ans1 = dp[i-1][j-v];
                    boolean ans2 = dp[i-1][j];

                    dp[i][j] =  ans1 || ans2;
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args){
        int val[] = {4,2,7,1,3};
        int sum = 10;
        System.out.println(targetSum(val, sum));     
    }
}
