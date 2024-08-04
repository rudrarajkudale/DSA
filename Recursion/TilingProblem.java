package Recursion;

public class TilingProblem {
    public static int tileWays(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        int vertical = tileWays(n-1);
        int horizonatal = tileWays(n-2);
        int ways = vertical + horizonatal;
        return ways;
    }
    public static void main(String[] args) {
        System.out.println(tileWays(4));
    }
}
