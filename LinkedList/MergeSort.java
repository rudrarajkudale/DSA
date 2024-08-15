package LinkedList;

public class MergeSort {
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

    Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Node mergesort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        //find mid
        Node mid = findMid(head);
        Node righthead = mid.next;
        mid.next = null;

        //now call merge sort for both part
        Node left = mergesort(head);
        Node right = mergesort(righthead);

        return merge(left, right);
    }

    Node merge(Node left, Node right){
        Node MergeLL = new Node(-1);
        Node temp = MergeLL;

        while(left != null && right != null){
            if(left.data < right.data){
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }else{
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }

        while(right != null){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        while(left != null){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        return MergeLL.next;
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
        MergeSort ll = new MergeSort();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();
        head = ll.mergesort(head);
        ll.print();
    }
}
