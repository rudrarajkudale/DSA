package LinkedList;
import java.util.LinkedList;


//linked list using Java Collection Framework
public class LinkedListFramework {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.addFirst(2);
        l1.addFirst(1);
        l1.addFirst(0);
        l1.addLast(4);
        l1.addLast(5);
        System.out.println(l1);
        l1.removeFirst();
        l1.removeLast();
        System.out.println(l1);
    }
}
