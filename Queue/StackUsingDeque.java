package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {
    static class Stack{
        Deque<Integer> q = new LinkedList<>();
        
        void push(int data){
            q.addFirst(data);
        }

        int pop(){
            return q.removeFirst();
        }

        int peek(){
            return q.getFirst();
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}
