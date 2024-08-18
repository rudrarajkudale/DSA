package GreedyAlgo;

import java.util.*;

public class ChocolateProblem {
    public static void main(String[] args)
    {
        Integer vercost[] = {2,1,3,1,4};
        Integer horcost[] = {4,1,2};

        Arrays.sort(vercost, Collections.reverseOrder());
        Arrays.sort(horcost, Collections.reverseOrder());

        int v = 0, h = 0;
        int vp = 1, hp = 1;
        int minprice = 0;
        while(v < vercost.length && h < horcost.length){
            if(vercost[v] >= horcost[h]){
                minprice += vercost[v] * hp;
                v++;
                vp++;       
            }
            else{
                minprice += horcost[h] * vp;
                h++;
                hp++;
            }
        }

        while(v < vercost.length){
            minprice += vercost[v] * hp;
            v++;
            vp++;
        }

        while(h < horcost.length){
            minprice += horcost[h] * vp;
            h++;
            hp++;
        }

        System.out.println("The minimum price is: " + minprice);
    }
}
