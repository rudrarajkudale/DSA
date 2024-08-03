package BitManipulation;

//if 0 then clear bit
//if 1 then set bit
public class Update_ithBit {
    public static int updateBit(int n, int i, int bit){
        int bitmask = ~(1<<i);
        int num = n & bitmask;
        return num | bit<<i;

    } 
    public static void main(String[] args) {
        int n = 7;
        System.out.println(updateBit(n, 3, 1));
    }
}
