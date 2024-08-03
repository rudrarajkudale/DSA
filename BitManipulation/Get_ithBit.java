package BitManipulation;

public class Get_ithBit {
    public static int getBit(int n, int i){
        int bitmask = 1<<i;
        if((n & bitmask) == 0){
            return 0;
        }else{
            return 1;
        }
    }
    public static void main(String[] args) {
        int n = 7;
        System.out.println(getBit(n, 2));
    }
}
