package LinkedList;

public class CreateLinkedList {
    //This class is used to create the nodes in the LinkedList
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //those are the static variables for LinkedList
    public static Node head;
    public static Node tail;
    public static int size = 0;

    //checl Linked List is Empty or not
    boolean isEmpty(){
        return head ==  null;
    }

    void addFirst(int data){
        Node newnode = new Node(data);
        size++;
        if(isEmpty()){
            head = tail = newnode;
            return;
        }
        newnode.next = head;
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
        tail = newnode;  
    }

    void addMiddle(int data, int idx){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newnode = new Node(data);
        size++;
        int i=0;
        Node temp = head;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }

    int removeFirst(){
        if(isEmpty()){
            return -1;
        }
        if(head == tail){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    int removeLast(){
        if(isEmpty()){
            return -1;
        }
        if(head == tail){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        size--;
        return val;
    }

    int iterativeSearch(int key){
        Node temp = head;
        for(int i=0; i<size; i++){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    int recursiveSearch(int key){
        return helper(head, key);
    }
    int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx + 1;
    }
    void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        CreateLinkedList l1 = new CreateLinkedList();
        l1.addFirst(2);
        l1.addFirst(1);
        l1.addFirst(0);
        l1.addLast(4);
        l1.addLast(5);
        l1.addMiddle(3, 3);
        l1.print();
        System.out.println(l1.recursiveSearch(3));
        l1.removeFirst();
        l1.removeLast();
        System.out.println(l1.iterativeSearch(5));
        l1.print();
    }
}
