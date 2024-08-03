package BitManipulation;

public class FastExponent {
    public static void fastExponent(int n, int p){
        int ans = 1;
        while(p > 0){
            if((p & 1) == 1){
                ans = ans * n; 
            }
            n = n * n;
            p = p >> 1;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        fastExponent(5,4);
    }
}
