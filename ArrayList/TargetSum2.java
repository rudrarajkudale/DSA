package ArrayList;
import java.util.ArrayList;

//In this th array is sorted amd rotated from the pivot
public class TargetSum2 {
    public static boolean targetSum2(ArrayList<Integer> sorted, int sum){
        int n = sorted.size();
        int breakp = -1;
        for(int i=0; i<n-1; i++){
            if(sorted.get(i) > sorted.get(i+1)){
                breakp = i;
                break;
            }
        }
        int start = breakp + 1;
        int end = breakp;
        while(start != end){
            if(sorted.get(start) + sorted.get(end) == sum){
                return true;
            }
            if(sorted.get(start) + sorted.get(end) < sum){
                start = (start+1) % n;
            }else{
                end = (n + end-1) % n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> sorted = new ArrayList<>();
        sorted.add(11);
        sorted.add(15);
        sorted.add(6);
        sorted.add(8);
        sorted.add(9);
        sorted.add(10);
        System.out.println(targetSum2(sorted, 16));
    }

}
