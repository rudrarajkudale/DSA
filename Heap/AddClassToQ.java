package Heap;

import java.util.PriorityQueue;

public class AddClassToQ {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }


    public static void main(String[] args) {
        PriorityQueue<Student> q = new PriorityQueue<>();

        q.add(new Student("Rudra", 4));
        q.add(new Student("Atharva", 2));
        q.add(new Student("Yash", 1));
        q.add(new Student("Pranav", 3));

        while(!q.isEmpty()){
            System.out.print(q.remove().name + " ");
        }
        System.out.println();
    }
}
