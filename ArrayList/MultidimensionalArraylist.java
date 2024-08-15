package ArrayList;

import java.util.ArrayList;

public class MultidimensionalArraylist {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(4);
        arr2.add(5);
        arr2.add(6);
        ArrayList<ArrayList<Integer>> main = new ArrayList<>();
        main.add(arr1);
        main.add(arr2);
        System.out.println(main);

        //one by one print
        for(int i=0; i<main.size(); i++){
            ArrayList<Integer> temp = main.get(i);
            for(int j=0; j<temp.size(); j++){
                System.out.print(temp.get(j) + " ");
            }
            System.out.println();
        }
    }
}
