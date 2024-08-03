package BitManipulation;

public class OddEven {
    public static void oddEven(int n){
        int bit = 1;
        if((n & bit) == 0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }
    public static void main(String[] args) {
        int n = 4;
        oddEven(n);
    }
}
