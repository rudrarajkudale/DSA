package Heap;

import java.util.PriorityQueue;

public class SlidingWindowMax {
    static class Window implements Comparable<Window>{
        int val;
        int i;
        Window(int val, int i){
            this.val = val;
            this.i = i;
        }
        @Override
        public int compareTo(Window w2){
            return w2.val - this.val;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        //create priority queue sorting in desceding order to find max
        PriorityQueue<Window> q = new PriorityQueue<>();
        //create res array to store result of size length - 2;
        int res[] = new int[arr.length - k + 1];
        //pass first 3 values
        for(int i=0; i<k; i++){
            q.add(new Window(arr[i], i));
        }
        
        res[0] = q.peek().val;

        //pass remaining values
        for(int i=k; i<arr.length; i++){
            //remove value if greater than window size
            while(q.peek().i <= i-k ){
                q.remove();
            }
            q.add(new Window(arr[i], i));
            res[i-k+1] = q.peek().val;
        }

        //print results
        for(int i=0; i<res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}
