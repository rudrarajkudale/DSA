package GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoin {
    public static void main(String[] args)
    {
        Integer coins[] = {1,2,5,10,20,50,100,500,1000};
        Arrays.sort(coins, Comparator.reverseOrder());

        int coin = 0;
        int ammount = 2036;

        int i=0;
        ArrayList<Integer> rupee = new ArrayList<>();
        while(ammount != 0){
            while(ammount >= coins[i]){
                ammount -= coins[i];
                coin++;
                rupee.add(coins[i]);
            }
            i++;
        }
        System.out.println("Totals coins required: " + coin);
        System.out.println(rupee);
    }
}
