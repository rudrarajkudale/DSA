package DynamicProgramming;

public class EditDistance {
    public static int editDistance(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            dp[i][0] = i;
        }
        for(int j=1; j<=m; j++){
            dp[0][j] = j;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int Replace = dp[i-1][j-1] + 1;

                    dp[i][j] = Math.min(add, Math.min(del, Replace));
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args){
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(editDistance(str1, str2));
    }
}
