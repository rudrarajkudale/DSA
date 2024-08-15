package LinkedList;

public class Palindrome {
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


    Node findMid(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    boolean checkPalindrome(){
        //if there is on;y single ele or empty then true
        if(head == null || head.next == null){
            return true;
        }

        //find mid
        Node mid = findMid();

        //reverse linkes list from the mid
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // now check palindrome or not
        Node left = head;
        Node right = prev;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
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
        Palindrome l1 = new Palindrome();
        l1.addFirst(0);
        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(2);
        l1.addFirst(1);
        l1.addFirst(0);
        System.out.println(l1.checkPalindrome());
    }
}
