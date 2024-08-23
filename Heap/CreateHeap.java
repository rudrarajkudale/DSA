package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CreateHeap {
    public static void main(String[] args) {
        //sort in ascending order
        PriorityQueue<Integer> q = new PriorityQueue<>();

        q.add(3);
        q.add(2);
        q.add(4);
        q.add(1);

        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();


        //sort in descending order
        PriorityQueue<Integer> q2 = new PriorityQueue<>(Comparator.reverseOrder());

        q2.add(3);
        q2.add(2);
        q2.add(4);
        q2.add(1);

        while(!q2.isEmpty()){
            System.out.print(q2.remove() + " ");
        }
    }
}
