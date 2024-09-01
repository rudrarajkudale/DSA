package DynamicProgramming;

public class WildCardMatching {
    public static boolean WildCardEntry(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=1; i<=n; i++){
            dp[i][0] = false;
        }
        for(int j=1; j<=m; j++){
            if (s2.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            } 
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1) || s2.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(s2.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args){
        String str1 = "baaabab";
        String str2 = "**ba***ab";
        System.out.println(WildCardEntry(str1, str2));
    }
}
