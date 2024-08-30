package DynamicProgramming;

//It is by Using Tabulation
public class Fibonacci2 {
    public static int fibonacci(int n){
        int f[] = new int[n+1];

        f[0] = 1;
        f[1] = 1;


        for(int i=2; i<=n; i++){
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println(fibonacci(n));
    }
}
