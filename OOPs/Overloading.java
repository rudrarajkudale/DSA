package OOPs;

public class Overloading {
    public static void main(String[] args)
    {
        Sum sum1 = new Sum(1,2);
        Sum sum2 = new Sum(1,2,3);
        Sum sum3 = new Sum((float)1.4,(float)2.9);
    }      
}
class Sum{
    Sum(int a, int b){
        System.out.println(a+b);
    }
    Sum(int a, int b, int c){
        System.out.println(a+b+c);
    }
    Sum(float a, float b){
        System.out.println(a+b);
    }
}

