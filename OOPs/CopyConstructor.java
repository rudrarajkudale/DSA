package OOPs;

public class CopyConstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Rudra";
        s1.age = 21;
        s1.classroom = 1;
        s1.marks[0] = 90;
        s1.marks[1] = 85;
        s1.marks[2] = 80;

        Student s2 = new Student(s1);
        System.out.println(s2.name + ", " + s2.age + ", " + s2.classroom + ", marks: " 
                           + s2.marks[0] + "," + s2.marks[1] +  "," + s2.marks[2]);
    }
}

class Student{
    String name;
    int age;
    int classroom;
    int marks[] = new int[3];

    Student(){
        System.out.println("Student created");
    }

    Student(Student s1){
        this.name = s1.name;
        this.age = s1.age;
        this.classroom = s1.classroom;
        
        //it is shallow copy
        //this.marks = s1.marks;

        //it is deep copy
        for(int i=0; i<s1.marks.length; i++){
            this.marks[i] = s1.marks[i];
        }
    }
}
