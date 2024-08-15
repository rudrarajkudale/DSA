package LinkedList;

public class DoublyLinkedList {
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

    void addLast(int data){
        Node newnode = new Node(data);
        size++;
        if(isEmpty()){
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        newnode.prev = tail;
        tail = newnode;
    }

    void addMiddle(int data, int idx){
        if(idx == 0){
            addFirst(data);
            return;
        }
        if(idx == size){
            addLast(data);
            return;
        }
        Node newnode = new Node(data);
        size++;
        Node temp = head;
        for(int i=0; i<idx-1; i++){
            temp = temp.next;
        }
        newnode.prev = temp;
        newnode.next = temp.next;
        temp.next.prev = newnode;
        temp.next = newnode; 

    }

    int removeFirst(){
        if(head == null){
            return -1;
        }
        int val = head.data;
        if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
            head.prev = null;
        }
        size--;
        return val;
    }

    int removeLast(){
        if(head == null){
            return -1;
        }
        int val = tail.data;
        if(head == tail){
            head = tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return val;
    }

    int removeMiddle(int idx){
        if(idx == 0){
            return removeFirst();     
        }
        if(idx == size-1){
            return removeLast();
        }
        Node temp = head;
        for(int i=0; i<idx-1; i++){
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
        return val;
    }

    static void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.addFirst(2);
        dl.addFirst(1);
        dl.addLast(5);
        dl.addLast(6);
        dl.addMiddle(3, 2);
        dl.addMiddle(4, 3);
        print();
        dl.removeFirst();
        dl.removeLast();
        dl.removeMiddle(2);
        print();
    }
}
