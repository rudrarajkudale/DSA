package GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        //create 2D array to remember index after sorting
        int n = start.length;
        int activity[][] = new int[n][3];
        for(int i=0; i<n; i++){
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }   

        //noe sort 2D array
        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));

        //now check activities can done
        int MaxActivity = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(activity[0][0]);
        int lastActivity = activity[0][2];
        for(int i=1; i<n; i++){
            if(activity[i][1] > lastActivity){
                lastActivity = activity[i][2];
                MaxActivity++;
                arr.add(activity[i][0]);
            }
        }

        //now print maxActivities
        System.out.println("Total Activities done are:" + MaxActivity);
        for(int i=0; i<arr.size(); i++){
            System.out.print("A" + arr.get(i) + " ");
        }
        
    }
}
