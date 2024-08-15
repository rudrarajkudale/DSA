package LinkedList;

public class ReverseLinkedList {
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

    void reverseLinkedList(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        ReverseLinkedList l1 = new ReverseLinkedList();
        l1.addFirst(0);
        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(3);
        l1.addFirst(4);
        l1.reverseLinkedList();
        l1.print();
    }
}
