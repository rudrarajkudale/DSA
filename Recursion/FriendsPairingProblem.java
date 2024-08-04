package Recursion;

public class FriendsPairingProblem {
    public static int friendsPairing(int n){
        if(n == 1 || n == 2){
            return n;
        }
        int single = friendsPairing(n-1);
        int pair = single *  friendsPairing(n-2);
        int ways = single + pair;
        return ways;
    }
    public static void main(String[] args) {
        System.out.println(friendsPairing(3));
    }
}
