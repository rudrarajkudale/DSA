package Heap;

import java.util.PriorityQueue;

public class ConnectNropes {
    public static void main(String[] args){
        int arr[] = {2,3,3,4,6};

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            q.add(arr[i]);
        }
        int cost = 0;

        while(q.size() > 1){
            int min1 = q.remove();
            int min2 = q.remove();
            cost += min1 + min2;
            q.add(min1 + min2);
        }

        System.out.println("The cost to connect N ropes is: " + cost);
    }
}
