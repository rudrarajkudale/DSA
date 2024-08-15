package Stack;
import java.util.ArrayList;

public class UsingArrayList {
    static class Stack{
        ArrayList<Integer> arr = new ArrayList<>();

        boolean isEmpty(){
            return arr.size() == 0;
        }

        void push(int data){
            arr.add(data);
        }

        int pop(){
            if(isEmpty()){
                return -1;
            }
            return arr.remove(arr.size()-1);
        }

        int peek(){
            return arr.get(arr.size()-1);
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
