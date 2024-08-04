package OOPs;

public class Constructor {
    public static void main(String[] args){
        Pen p1 = new Pen("blue", 5);
        System.out.println(p1.color + "," + p1.tip);
    }
}

class Pen{
    String color;
    int tip;

    Pen(String color, int tip){
        this.color = color;
        this.tip = tip;
    }
}
