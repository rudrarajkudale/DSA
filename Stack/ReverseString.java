package Stack;
import java.util.Stack;

public class ReverseString {
    public static String reverseString(String str){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            st.push(str.charAt(i));
        }
            
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "Rudraraj";
        System.out.println(reverseString(str));
    }
}
