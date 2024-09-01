package DynamicProgramming;

import java.util.*;

public class LongestIncreasingSubsequence {
    //do it by tabulation
    public static int LISUtil(int val[], int arr[]){
        int n = val.length;
        int m = arr.length;

        int dp[][] = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(val[i-1] == arr[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    //first have to find unique elements in sorted manner
    //so we can compare with main array
    public static int LIS(int val[]){
        HashSet<Integer> h = new HashSet<>();
        for(int i=0; i<val.length; i++){
            h.add(val[i]);
        }

        //now store then in array and sort it
        int arr[] = new int[h.size()];
        int i = 0;
        for(int n : h){
            arr[i] = n;
            i++;
        }
        Arrays.sort(arr);

        return LISUtil(val, arr);
    }
    public static void main(String[] args){
        int val[] = {15, 3, 10, 7, 40, 80};
        System.out.println(LIS(val));
    }
}
