package DynamicProgramming;

public class CatalansNo {
    //By recusrion
    public static int catlanaRec(int n){
        if(n == 1 || n == 0){
            return 1;
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += catlanaRec(i) * catlanaRec(n-1-i);
        }
        return ans;
    }

    //By Memorization
    public static int catlanaMemo(int n, int dp[]){
        if(n == 1 || n == 0){
            return 1;
        }

        if(dp[n] != 0){
            return dp[n];
        }
        
        int ans = 0;
        for(int i=0; i<n; i++){
            ans += catlanaMemo(i, dp) * catlanaMemo(n-1-i, dp);
        }
        dp[n] = ans;
        return dp[n];
    }

    //By tabulation
    public static int catlanaTab(int n){
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }
    public static void main(String[] args){
        int n = 4; 
        
        //by recursion
        System.out.println(catlanaRec(n));

        //By memorization
        int dp[] = new int[n+1];
        System.out.println(catlanaMemo(n, dp));

        //By Tabulation
        System.out.println(catlanaTab(n));
    }
}
