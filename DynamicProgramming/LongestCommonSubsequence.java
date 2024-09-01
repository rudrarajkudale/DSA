package DynamicProgramming;

public class LongestCommonSubsequence {
    //It is By recursion
    public static int LCSRec(String str1, String str2, int n, int m){
        if(n==0 || m == 0){
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return LCSRec(str1, str2, n-1, m-1) + 1;
        }
        else{
            return Math.max(LCSRec(str1, str2, n-1, m), LCSRec(str1, str2, n, m-1));
        }
    }

    public static int LCSMemo(String str1, String str2, int n, int m, int dp[][]){
        if(n == 0 || m == 0){
            return 0;
        }

        if(dp[n][m] != 0){
            return dp[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m] = LCSMemo(str1, str2, n-1, m-1, dp) + 1;
        }
        else{
            return dp[n][m] = Math.max(LCSMemo(str1, str2, n-1, m, dp), LCSMemo(str1, str2, n, m-1, dp));
        }
    }

    public static int LCSTab(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] =  new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args){
        String str1 = "abcdeg";
        String str2 = "abedg";
        //by recursion
        System.out.println(LCSRec(str1, str2, str1.length(), str2.length()));

        //By Memorization
        int n = str1.length(), m = str2.length();
        int dp[][] = new int[n+1][m+1];
        System.out.println(LCSMemo(str1, str2, n, m, dp));

        //By Tabulation
        System.out.println(LCSTab(str1, str2));
    }
}
