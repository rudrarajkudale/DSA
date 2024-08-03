package Arrays;

import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int arr[]){
        HashSet<Integer> hm = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            if(hm.contains(arr[i])){
                return true;
            }else{
                hm.add(arr[i]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,2,6};
        System.out.println(containsDuplicate(arr));
    }
}
