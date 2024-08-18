package Stack;
import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ')'){
                int count = 0;
                while(s.pop() != '('){
                    count++;
                }
                if(count == 0){
                    return true;
                }       
            }else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str1 = "((a+b)+(c+d))";
        String str2 = "((a+b))";
        System.out.println(isDuplicate(str1));
        System.out.println(isDuplicate(str2));

    }
}