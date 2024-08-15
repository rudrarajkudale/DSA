package Stack;
import java.util.Stack;

public class ParanthesisValid {
    public static boolean paranthesisValid(String str){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '{' || ch == '[' || ch == '('){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                if((ch == ')' && st.peek() == '(') ||
                   (ch == '}' && st.peek() == '{') ||
                   (ch == ']' && st.peek() == '[') ){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        String str = "{[(())]})";
        System.out.println(paranthesisValid(str));
    }
}
