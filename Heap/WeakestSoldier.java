package Heap;

import java.util.PriorityQueue;

public class WeakestSoldier {
    static class WS implements Comparable<WS>{
        int count;
        int i;
        WS(int count, int i){
            this.count = count;
            this.i = i;
        }
        @Override
        public int compareTo(WS w2){
            if(this.count != w2.count){
                return this.count - w2.count;
            }
            return this.i - w2.i;
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1,0,0,0},
                       {1,1,1,1},
                       {1,0,0,0},
                       {1,0,0,0}};
        int k = 2;


        PriorityQueue<WS> q = new PriorityQueue<>();
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
