package OOPs;

public class Single_LvL_Inheritance {
    public static void main(String[] args)
    {
        Dog d1 = new Dog();
        d1.name = "max";
        d1.legs = 4;
        d1.walk();
    }
        
}
class Mammals{
    String name;
    int legs;
    void walk(){
        System.out.println("also can walk");
    }
    void breath(){
        System.out.println("also can breath");
    }
}

class Dog extends Mammals{
    void bark()
    {
        System.out.println("dog can bark");
    }
}

