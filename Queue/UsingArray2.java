package Queue;

//It is a circular Queue Implemented by arrays
public class UsingArray2 {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        Queue(int n){
            arr = new int[n]; 
            size = n;
            rear = -1;
            front = -1;
        }

        //adding - O(1)
        void add(int data){
            if((rear + 1) % size == front){
                System.out.println("Queue is full");
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        } 

        //check empty - O(1)
        boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        //remove - O(n)
        int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int val = arr[front];
            if(front == rear){
                front = rear = -1;
            }
            else{
                front = (front + 1) % size;
            }
            return val;
        }

        //check peek = O(1)
        int peek(){
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.peek());
        q.remove();
        q.add(6);
        System.out.println(q.peek());
    }
}
