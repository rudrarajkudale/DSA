package BitManipulation;

public class PowerOf2 {
    public static boolean checkPowerOf2(int n){
        return (n & (n-1)) == 0;
    }
    public static void main(String[] args) {
        int n = 16;
        System.out.println(checkPowerOf2(n));
    }
}
