package Queue;

import java.util.LinkedList;
import java.util.Queue;

//Implement Queue Using Java Collection Framework
//It is created By using LinkedList(Dynamic capacity)
public class UsingFramework {
    public static void main(String[] args) {

        //Queue is an inteface so we have to implement Using Linked List class
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
        q.remove();
        System.out.println(q.peek());
    }
}
