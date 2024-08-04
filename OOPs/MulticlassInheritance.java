package OOPs;

public class MulticlassInheritance {
    public static void main(String[] args)
    {
        Bear b = new Bear();
        b.vegetarian();
        b.nonvegetarian();
    }      
}

interface Herbivore{
    void vegetarian();
}

interface Carnivore{
    void nonvegetarian();
}

class Bear implements Herbivore, Carnivore {
    public void vegetarian(){
        System.out.println("eats leaf, wood");
    }
    public void nonvegetarian(){
        System.out.println("eats fish, meat");
    }
}

