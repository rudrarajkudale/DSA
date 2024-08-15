package Stack;
import java.util.Stack;

public class PushBottom {
    public static void pushBottom(Stack<Integer> st, int data){
        if(st.isEmpty()){
            st.push(data);
            return;
        }

        int top = st.pop();
        pushBottom(st, data);
        st.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        pushBottom(st, 5);

        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
    }
}
