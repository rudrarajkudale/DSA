package Heap;

import java.util.PriorityQueue;

//we can write overide logic while creating Priority Queue
public class WeakestSoldier2 {
    static class WS{
        int count;
        int i;
        WS(int count, int i){
            this.count = count;
            this.i = i;
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1,0,0,0},
                       {1,1,1,1},
                       {1,0,0,0},
                       {1,0,0,0}};
        int k = 2;


        PriorityQueue<WS> q = new PriorityQueue<>((w1, w2) -> {
            if(w1.count != w2.count){
                return w1.count - w2.count;
            }
            return w1.i - w2.i;
        });
        for(int i=0; i<arr.length; i++){
            int count = 0;
            for(int j=0; j<arr[0].length; j++){
                count += arr[i][j];
            }
            q.add(new WS(count, i));
        }   

        for(int i=0; i<k; i++){
            System.out.println(q.remove().i);
        }
    }
}
