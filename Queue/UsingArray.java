package Queue;

//It is Normal Queue implemented Using Arrays
public class UsingArray {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        Queue(int n){
            arr = new int[n]; 
            size = n;
            rear = -1;
        }

        //adding - O(1)
        void add(int data){
            if(rear == size-1){
                System.out.println("Queue is full");
            }
            rear++;
            arr[rear] = data;
        } 

        //check empty - O(1)
        boolean isEmpty(){
            return rear == -1;
        }

        //remove - O(n)
        int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int val = arr[0];
            for(int i=0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            return val;
        }

        //check peek = O(1)
        int peek(){
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
        q.remove();
        System.out.println(q.peek());
    }
}
