package DynamicProgramming;

//By Using Memorization
public class Fibonacci {
    public static int fibonacci(int n, int f[]){
        if(n == 0){
            return 1;
        }

        if(f[n] != 0){
            return f[n];
        }

        f[n] = fibonacci(n-1, f) + fibonacci(n-2, f);
        return f[n];
    }
    public static void main(String[] args) {
        int n = 6;
        int f[] = new int[n+1];
        System.out.println(fibonacci(n, f));
    }
}
