package DynamicProgramming;

//same as Fibonacci
//count a way to each nth stair
//person can climb 1 stair or 2 stair
public class ClimbingStairs {
    public static int countWaysMemorization(int n, int count[]){
        if(n == 0 || n == 1){
            return 1;
        }

        if(count[n] != 0){
            return count[n];
        }

        count[n] = countWaysMemorization(n-1, count) + countWaysMemorization(n-2, count);
        return count[n];
    }

    public static int countWaysTabulation(int n){
        int count[] = new int[n+1];

        count[0] = 1;
        count[1] = 1;

        for(int i=2; i<=n; i++){
            count[i] = count[i-1] + count[i-2];
        }
        return count[n];
    }
    public static void main(String[] args) {
        int n=5;
        int count[] = new int[n+1];
        System.out.println(countWaysMemorization(n, count));
        System.out.println(countWaysTabulation(n));
    }
}
