package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingDeque {
    static class Queue{
        Deque<Integer> q = new LinkedList<>();
        
        void add(int data){
            q.addLast(data);
        }

        int remove(){
            return q.removeFirst();
        }

        int peek(){
            return q.getFirst();
        }
    }
    public static void main(String[] args)
    {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek" + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
