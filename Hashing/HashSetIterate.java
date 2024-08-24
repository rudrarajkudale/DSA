package Hashing;
import java.util.HashSet;
import java.util.Iterator;

//By using Normal Iterator
public class HashSetIterate {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        hs.add(1);
        hs.add(3);
        hs.add(2);
        hs.add(0);

        //By using Normal Iterator
        Iterator<Integer> i = hs.iterator();
        while(i.hasNext()){
            System.out.print(i.next() + " ");
        }
        System.out.println();
       
        //By using advance loop
        for(Integer num : hs){
            System.out.print(num + " ");
        }
    }
}
