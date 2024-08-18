package Queue;
import java.util.Stack;

//We Implemet Queue By using 2 Stacks
public class ImplementQueueUsingStacks {
    static class Queue{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        //O(n)
        void add(int data){
            if(s1.isEmpty()){
                s1.push(data);
                return;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        //O(1)
        int remove(){
            if(s1.isEmpty()){
                return -1;
            }
            return s1.pop();
        }

        //O(1)
        int peek(){
            if(s1.isEmpty()){
                return -1;
            }
            return s1.peek();
        }

        //Or we can Implement like
        // add - O(1)
        //remove - O(n)
        //peek - O(n)
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
        q.remove();
        System.out.println(q.peek());
    }
}
