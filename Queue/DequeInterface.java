package Queue;

import java.util.*;

//deque - it is double ended queue
//dequeue - remove from queue
public class DequeInterface {
    public static void main(String[] args) {
        Deque<Integer> q = new LinkedList<>();
        //add
        q.addFirst(2);
        q.addFirst(1);
        q.addLast(3);
        q.addLast(4);
        System.out.println(q);

        //remove
        q.removeFirst();
        q.removeLast();
        System.out.println(q);

        //peek
        System.out.println(q.getFirst());
        System.out.println(q.getLast());
    }
}
