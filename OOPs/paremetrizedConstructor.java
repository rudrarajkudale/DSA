package OOPs;

public class paremetrizedConstructor {
    public static void main(String[] args){
        Pen p1 = new Pen("blue");
        Pen p2 = new Pen(5);
        Pen p3 = new Pen();
    }
}

class Pen{
    String color;
    int tip;

    Pen(){ //non parametrized constructor
        System.out.println("Contructor called");
    }

    //parametrized constructors
    Pen(String color){ 
        this.color = color;
    }
    Pen(int tip){
        this.tip = tip;
    }
}
