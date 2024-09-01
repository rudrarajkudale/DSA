package DynamicProgramming;

//same as unbounded snapsack
public class RodCutting {
    public static int rodCutting(int prize[], int length[], int L){
        int n = prize.length;
        int dp[][] = new int[n+1][L+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=L; j++){
                int p = prize[i-1];
                int l = length[i-1];
                if(l <= j){
                    dp[i][j] = Math.max(dp[i][j-l] + p, dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][L];
    }
    public static void main(String[] args){
        int prize[] = {1,5,8,9,10,17,17,20};
        int length[] = {1,2,3,4,5,6,7,8};
        int L = 8;
        System.out.println(rodCutting(prize, length, L));     
    }
}

