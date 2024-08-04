package OOPs;

public class hierachicalInheritance {
    public static void main(String[] args)
    {
        Mammals d1 = new Mammals();
        Fish f1 = new Fish();
        d1.name = "max";
        f1.name = "sam";
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

