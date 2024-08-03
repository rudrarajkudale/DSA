package BitManipulation;

public class ClearLast_iBits {
    public static int clearLastBits(int n, int i){
        int bitmask = ~(0)<<i;
        return n & bitmask;
    }
    public static void main(String[] args) {
        int n = 15;
        System.out.println(clearLastBits(n, 3));
    }
}
