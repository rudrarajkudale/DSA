package DynamicProgramming;

//It is Using tabulation
public class Knapsack013 {

    public static int knapsackTab(int val[], int wt[], int W){
        int n = val.length;

        int dp[][] = new int[n+1][W+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int i=0; i<=W; i++){
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){
                int v = val[i-1];
                int w = wt[i-1];

                if(j >= w){
                    int ans1 = v + dp[i-1][j-w];
                    int ans2 = dp[i-1][j];

                    dp[i][j] = Math.max(ans1, ans2);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        System.out.println(knapsackTab(val, wt, W));
    }
}
