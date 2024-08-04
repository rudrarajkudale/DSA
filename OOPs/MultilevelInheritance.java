package OOPs;

public class MultilevelInheritance {
    public static void main(String[] args)
    {
        Dog d1 = new Dog();
        d1.name = "max";
        d1.legs = 4;
        d1.eat();
        d1.walk();
    }
        
}
class Animal {
    String name;
    void eat(){
        System.out.println("also can eat");
    }
    void breath(){
        System.out.println("also can breath");
    }
}
class Mammals extends Animal{
    
    int legs;
    void walk(){
        System.out.println("also can walk");
    }
}

class Dog extends Mammals{
    void bark()
    {
        System.out.println("dog can bark");
    }
}
    
