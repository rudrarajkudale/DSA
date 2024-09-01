package DynamicProgramming;

//same as catalon
public class CountingTrees {
    //by tabulation
    public static int countingTree(int n){
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                int left = dp[j];
                int right = dp[i-1-j];
                dp[i] += left * right;
            }
        }

        return dp[n];
    }
    public static void main(String[] args){
        System.out.println(countingTree(4));
    }

}
