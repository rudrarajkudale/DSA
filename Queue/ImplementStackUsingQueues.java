package Queue;

import java.util.LinkedList;
import java.util.Queue;

//Now we implement Stack By using 2 queues
public class ImplementStackUsingQueues {
    static class Stack{
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        //O(1)
        void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }
            else{
                q2.add(data);
            }       
        }

        //O(n)
        int pop(){
            int top = -1;
            if(q1.isEmpty()){
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);  
                }
            }
            else{
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);  
                }
            }
            return top;
        }

        //O(n)
        int peek(){
            int top = -1;
            if(q1.isEmpty()){
                while(!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);  
                }
            }
            else{
                while(!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);  
                }
            }
            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}