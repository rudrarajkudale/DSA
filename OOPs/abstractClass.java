package OOPs;

public class abstractClass {
    public static void main(String[] args)
    {
        //can't create abstract class instances
        //Animal a = new Animal();
        Horse h1 = new Horse();
        h1.walk();
        Chicken c1 = new Chicken();
        c1.walk();
        c1.changecolor();
    }      
}
abstract class Animal{
    String color;
    Animal()//can create constructor of animal class
    {
        //when create subclasses and try to create objects then animal 
        //constructor runs first then subclass constructor
        System.out.println("animal class called");
        color = "brown";
    }
    void eat()
    {
        System.out.println("eat anything");
    }
    abstract void walk(); // can be create abstract functions
}

class Horse extends Animal{
    void changecolor(){
        color = "dark brown"; //by default it is brown defined in parent
    }
    void walk(){
        System.out.println("walk on 4 legs");
    }
}

class Chicken extends Animal{
    void changecolor(){
        color = "white";
    }
    void walk(){
        System.out.println("walk on 2 legs");
    }
}
    
