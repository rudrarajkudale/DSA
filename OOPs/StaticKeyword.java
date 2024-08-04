package OOPs;

public class StaticKeyword {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Rudra";
        s1.age = 18;    
    }
}
class Student{
    String name; 
    int age;
    static String school ; //attribute
    static int displaymarks(int math, int sci, int marathi){ //method
        return (math+sci+marathi)/3;
    }
    static{
        System.out.println("i am the student of " + school); //block
    }

    static class Address { //class
        void printaddress(String area, int picode)
        {
            System.out.println(area + " " + picode);
        }
    }
}