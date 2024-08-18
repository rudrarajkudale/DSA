package Queue;


//Implement Queue using LinkedList 
public class UsingLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class Queue{
        public static Node head;
        public static Node tail;

        boolean isEmpty(){
            return head == null;
        }

        //O(1)
        void add(int data){
            Node newnode = new Node(data);
            if(isEmpty()){
                head = tail = newnode;
                return;
            }
            tail.next = newnode;
            tail = newnode;      
        }

        //O(1)
        int remove(){
            if(isEmpty()){
                return -1;
            }
            int val = head.data;
            if(head == tail){
                head = tail = null;
                return val;
            }
            head = head.next;
            return val;
        }

        //O(1)
        int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
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
