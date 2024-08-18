package Queue;

import java.util.Stack;

//In this
//we Implement like
        // add - O(1)
        //remove - O(n)
        //peek - O(n)
public class ImplementQueueUsingStacks2 {
    static class Queue{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        boolean isEmpty(){
            return s1.isEmpty();
        }
        //O(1)
        void add(int data){
            s1.add(data);
        }

        //O(n)
        int remove(){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int val = s2.pop();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return val;
        }

        //O(n)
        int peek(){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int val = s2.peek();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return val;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
