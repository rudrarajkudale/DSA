package DynamicProgramming;

public class UnboundedKnapsack {
    //By using tabulation
    public static int unBoundedKnapSack(int val[], int wt[], int W){
        int n = val.length;

        int dp[][] = new int[n+1][W+1];


        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){
                int v = val[i-1];
                int w = wt[i-1];

                if(j >= w){
                    dp[i][j] = Math.max(v + dp[i][j-w], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args){
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        System.out.println(unBoundedKnapSack(val, wt, W));     
    }

}
