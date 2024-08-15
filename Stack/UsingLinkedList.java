package Stack;
import java.util.LinkedList;

//it is by using Linked List framework
public class UsingLinkedList {
    static class Stack{
        LinkedList<Integer> ll = new LinkedList<>();

        boolean isEmpty(){
            return ll.isEmpty();
        }

        void push(int data){
            ll.addFirst(data);
        }

        int pop(){
            return ll.removeFirst();
        }

        int peek(){
            return ll.getFirst();
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        
        while(!s.isEmpty()){
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
}
