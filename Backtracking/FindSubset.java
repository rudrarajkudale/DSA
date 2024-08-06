package Backtracking;

public class FindSubset {
    public static void printSubstring(String str, int i, String ans){
        if(i == str.length()){
            if(ans.length() == 0)
                System.out.println("null");
            else
                System.out.println(ans);
            return;
        }
        printSubstring(str, i+1, ans+str.charAt(i));
        printSubstring(str, i+1, ans);
    }
    public static void main(String[] args) {
        String str = "abc";
        printSubstring(str, 0, "");
    }
}
