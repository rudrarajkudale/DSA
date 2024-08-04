package OOPs;

public class HybridInheritance {
    public static void main(String[] args)
    {
        Mammals m1 = new Mammals();
        Fish f1 = new Fish();
        Dog d1 = new Dog();
        d1.name = "max";
        f1.name = "sam";
        d1.legs = 4;
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

class Fish extends Animal{
    int fins;
    void swim(){
        System.out.println("can swim");
    }
}

class Dog extends Mammals{
    void bark()
    {
        System.out.println("dog can bark");
    }
}

