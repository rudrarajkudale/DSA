package DynamicProgramming;

public class MatrixChainMultiplication {

    //By recursion
    public static int MCMRec(int arr[], int i, int j){
        if(i == j){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int cost1 = MCMRec(arr, i, k);
            int cost2 = MCMRec(arr, k+1, j);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalcost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalcost);
        }  
        return ans;
    }

    public static int MCMMemo(int arr[], int i, int j, int dp[][]){
        if(i == j){
            return 0;
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int cost1 = MCMRec(arr, i, k);
            int cost2 = MCMRec(arr, k+1, j);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalcost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalcost);
        }  
        return dp[i][j] = ans;
    }

    //By Tabulation
    public static int MCMTab(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){
            dp[i][i] = 0;
        }

        for(int lvl = 2; lvl<=n-1; lvl++){
            for(int i=1; i<=n-lvl; i++){
                int j = lvl + i - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k<=j-1; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }
        return dp[1][n-1];
    }

    public static void main(String[] args){
        int arr[] = {1,2,3,4,3};

        // By Recursion
        System.out.println(MCMRec(arr, 1, arr.length-1));

        // By Memorization
        int n = arr.length;
        int dp[][] = new int[n][n];
        System.out.println(MCMMemo(arr, 1, arr.length-1, dp));

        // By Tabulation
        System.out.println(MCMTab(arr));
    }
}
