package Backtracking;

public class GridWays {
    // The time complexity of this code is exponential 
    // public static int gridWays(int i, int j, int n, int m){
    //     if(i == n-1 && j == m-1){
    //         return 1;
    //     }
    //     else if(i == n || j == m){
    //         return 0;
    //     }
    //     int right = gridWays(i+1, j, n, m);
    //     int down = gridWays(i, j+1, n, m);
    //     int ways = right + down;
    //     return ways;
    // }

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        int fact = n * factorial(n-1);
        return fact;
    }

    public static int gridWays(int n, int m){
        int down = n-1;
        int left = m-1;
        int w1 = factorial(down);
        int w2 = factorial(left);
        int w3 = factorial(down + left);
        return w3 / (w1 * w2);
    }
    public static void main(String[] args) {
        System.out.println(gridWays(3, 3));
    }
}
