package Heap;

import java.util.ArrayList;

public class Operations {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        void add(int data){
            arr.add(data);

            //get parent and child node
            int child = arr.size()-1;
            int par = (child - 1)/2;

            //swapn until child is minimum than parent
            while(arr.get(child) < arr.get(par)){
                int temp = arr.get(child);
                arr.set(child, arr.get(par));
                arr.set(par, temp);

                child = par;
                par = (child - 1)/2;
            }
        }

        int peek(){
            return arr.get(0);
        }

        boolean isEmpty(){
            return arr.size() == 0;
        }

        int remove(){
            int data = arr.get(0);

            //swap root node and last node and last node
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);
            
            arr.remove(arr.size()-1);

            //check after deleting satisfies min heap properties
            heapify(0);

            //return deleted node
            return data;
        }

        //heapify process
        void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int min = i;

            if(left < arr.size() && arr.get(left) < arr.get(min)){
                min = left;
            }
            if(right < arr.size() && arr.get(right) < arr.get(min)){
                min = right;
            }

            if(min != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(min));
                arr.set(min, temp);

                heapify(min);
            }
        }
    }

    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(2);

        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }

    }
}
