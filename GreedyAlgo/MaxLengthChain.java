package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChain {
    public static void main(String[] args) {
        int arr[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));

        int maxlength = 1;
        int Lastend = arr[0][1];
        for(int i=1; i<arr.length; i++){
            if(Lastend < arr[i][0]){
                Lastend = arr[i][1];
                maxlength++;
            }
        }

        System.out.println("Maximum length is: " + maxlength);
    }
}
