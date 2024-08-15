package ArrayList;

import java.util.ArrayList;

public class SwapElements {
    public static void swapElements(ArrayList<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        swapElements(arr, 1, 3);
        System.out.println(arr);
    }
}
