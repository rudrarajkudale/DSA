package Stack;
import java.util.Stack;

public class MaxAreaHistogram {
    public static void maxArea(int arr[]){
        Stack<Integer> s = new Stack<>();

        //find next smallest from right
        int nsr[] = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            int curr = arr[i];
            while(!s.isEmpty() && curr <= arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //find next smallest from left
        s = new Stack<>();
        int nsl[] = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            int curr = arr[i];
            while(!s.isEmpty() && curr <= arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        int maxarea = 0;
        for(int i=0; i<arr.length; i++){
            int w = nsr[i] - nsl[i] - 1;
            int h = arr[i];
            int area = w * h;
            maxarea = Math.max(maxarea, area);
        }
        System.out.println("The maximum area is:" + maxarea);
    }
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        maxArea(arr);
    }
}
