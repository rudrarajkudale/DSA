package LinkedList;

public class ReverseDL {
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    boolean isEmpty(){
        return head == null;
    }

    void addFirst(int data){
        Node newnode = new Node(data);
        size++;
        if(isEmpty()){
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }

    static void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void reverse(){
        Node curr = tail = head;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        ReverseDL dl = new ReverseDL();
        dl.addFirst(6);
        dl.addFirst(5);
        dl.addFirst(4);
        dl.addFirst(3);
        dl.addFirst(2);
        dl.addFirst(1);
        print();
        dl.reverse();
        print();
    }
}
