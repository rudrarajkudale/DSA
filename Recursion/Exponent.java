package Recursion;

public class Exponent {
    // not optimized solution
    // public static int exponent(int n, int pow){
    //     if(pow == 0){
    //         return 1;
    //     }
    //     n = n * exponent(n, pow-1);
    //     return n;
    // }

    //logn
    public static int exponent(int n, int pow){
        if(pow == 0){
            return 1;
        }
        int a = exponent(n, pow/2);
        int power = a * a;
        if(n % 2 != 0){
            power = n * power;
        }
        return power;
    }
    public static void main(String[] args) {
        System.out.println(exponent(5, 3));
    }
}

