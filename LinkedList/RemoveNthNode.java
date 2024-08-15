package LinkedList;

//remove node from the end
public class RemoveNthNode {
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

    void removeNthNode(int idx){
        int i = 1;
        int index = size - idx;
        Node temp = head;
        while(i < index){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
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
        RemoveNthNode l1 = new RemoveNthNode();
        l1.addFirst(0);
        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(3);
        l1.addFirst(4);
        l1.removeNthNode(2);
        l1.print();
    }
}
