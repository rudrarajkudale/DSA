package LinkedList;

public class ZigZagLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size = 0;

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

    void zigZag(){
        if(head == null || head.next == null){
            return;
        }

        //find mid
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        
        //reverse second half
        Node prev = null;
        Node curr = mid.next;
        Node next;
        mid.next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //now alternate merginf
        Node lefthead = head;
        Node righthead = prev;
        Node left, right;
        while(lefthead != null && righthead != null){
            //arrange
            left = lefthead.next;
            right = righthead.next;
            lefthead.next = righthead;
            righthead.next = left;

            //update
            lefthead = left;
            righthead = right;
        }
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
        ZigZagLinkedList ll = new ZigZagLinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();
        ll.zigZag();
        ll.print();
    }
}
