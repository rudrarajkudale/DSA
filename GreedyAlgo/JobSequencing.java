package GreedyAlgo;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
    static class Job{
        int deadline;
        int profit;
        int id;
        Job(int deadline, int profit, int id){
            this.deadline = deadline;
            this.profit = profit;
            this.id = id;
        }
    }
    public static void main(String[] args) {
        int jobinfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};

        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0; i<jobinfo.length; i++){
            jobs.add(new Job(jobinfo[i][0], jobinfo[i][1], i));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        int time = 0;
        int profit = 0;
        ArrayList<Integer> seq = new ArrayList<>();
        for(int i=0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time){
                time++;
                profit += curr.profit;
                seq.add(curr.id);
            }
        }

        System.out.println("Total profit is: " + profit);
        System.out.println(seq);
    }
}
