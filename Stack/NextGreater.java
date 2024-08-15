package Stack;
import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        int greater[] = new int[arr.length];
        Stack<Integer> temp = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            int curr = arr[i];
            while(!temp.isEmpty() && curr > arr[temp.peek()]){
                temp.pop();
            }
            if(temp.isEmpty()){
                greater[i] = -1;
            }else{
                greater[i] = arr[temp.peek()];
            }
            temp.push(i);
        }

        for(int i=0; i<greater.length; i++){
            System.out.print(greater[i] + " ");
        }
    }
}
