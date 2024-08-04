package OOPs;

public class SuperKeyword {
    public static void main(String[] args)
    {
        Traingle t = new Traingle();
        System.out.println(t.color);
    }      
}

class Shape{
    String color;
    Shape(){
        System.out.println("Shape is called");
    }
    void print(){
        System.out.println("i am a shape");
    }
}

class Traingle extends Shape{
    Traingle(){
        super();
        System.out.println("Traingle is called");
        super.color = "blue";
    }
}

