package ArrayList;
import java.util.ArrayList;
import java.util.Collections;

public class Operations {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        System.out.println(arr.get(3));
        arr.remove(2);
        arr.set(2, 5);
        arr.add(4);
        arr.add(1);
        System.out.println(arr.contains(2));
        System.out.println(arr.size());
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
        Collections.sort(arr, Collections.reverseOrder());
        System.out.println(arr);
    }
}
