package ArrayList;
import java.util.ArrayList;

//In this the Array is Sorted
public class TargetSum {
    public static boolean targetSum(ArrayList<Integer> sorted, int sum){
        int start = 0;
        int end = sorted.size()-1;
        while(start <= end){
            if(sorted.get(start) + sorted.get(end) == sum){
                return true;
            }
            if(sorted.get(start) + sorted.get(end) < sum){
                start++;
            }else{
                end--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> sorted = new ArrayList<>();
        sorted.add(1);
        sorted.add(2);
        sorted.add(3);
        sorted.add(4);
        sorted.add(5);
        sorted.add(6);
        System.out.println(targetSum(sorted, 50));
    }
}
