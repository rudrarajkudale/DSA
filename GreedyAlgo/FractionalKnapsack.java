package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60,100,120};
        int weight[] = {10,20,30};
        int W = 50;

        //create 2D array for storing the ratio
        int n = val.length;
        double ratio[][] = new double[n][2];
        for(int i=0; i<n; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double)weight[i];
        }
        //sort in ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        double maxval = 0;
        //sorted in ascending but want descending so reversed loop
        for(int i=n-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if(weight[idx] < capacity){
                maxval += val[idx];
                capacity -= weight[idx];
            }else{
                maxval += ratio[i][1] * capacity;
                capacity = 0;
                break; 
            }
        }
        System.out.println("The maximum value in a sack is: " + maxval);
    }  
}
