package BitManipulation;

public class Clear_ithBit {
    public static int clearBit(int n, int i){
        int bitmask = ~(1<<i);
       return n & bitmask;
    }
    public static void main(String[] args) {
        int n = 7;
        System.out.println(clearBit(n, 2));
    }
}

