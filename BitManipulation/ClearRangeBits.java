package BitManipulation;

public class ClearRangeBits {
    public static int clearRangeBits(int n, int i, int j){
        int bitmask1 = -1<<(j+1);
        int bitmask2 = (1<<i)-1;
        int bitmask = bitmask1 | bitmask2;
        return n & bitmask;
    }
    public static void main(String[] args) {
        int n = 15;
        System.out.println(clearRangeBits(n, 1, 2));
    }
}
