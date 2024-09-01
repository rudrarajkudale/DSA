package DynamicProgramming;

//It is by recursion
public class Knapsack01 {

    public static int knapsackRec(int val[], int wt[], int W, int n){
        if(W == 0 || n == 0){
            return 0;
        }
        if(W >= wt[n-1]){
            int ans1 = val[n-1] + knapsackRec(val, wt, W - wt[n-1], n-1);
            int ans2 = knapsackRec(val, wt, W, n-1);

            int ans = Math.max(ans1, ans2);
            return ans;
        }
        else{
            return knapsackRec(val, wt, W, n-1);
        }
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        System.out.println(knapsackRec(val, wt, W, val.length));
    }
}
