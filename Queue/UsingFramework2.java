package Queue;

import java.util.ArrayDeque;
import java.util.Queue;


//It is created By using ArrayDeque(Fixex capacity)
public class UsingFramework2 {
    public static void main(String[] args)
    {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty())
        {
            System.err.println(q.peek());
            q.remove();
        }
    }
}
