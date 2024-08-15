package Stack;
import java.util.Stack;

public class StockSpan {
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> temp = new Stack<>(); 
        span[0] = 1;
        temp.add(0);

        for(int i=1; i<stocks.length; i++){
            int curr = stocks[i];
            while(!temp.isEmpty() && curr > stocks[temp.peek()]){
                temp.pop();
            }
            if(temp.isEmpty()){
                span[i] = i + 1;
            }else{
                int prevhigh = temp.peek();
                span[i] = i - prevhigh;
            }
            temp.push(i);
        }
    }
    public static void main(String[] args) {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);

        for(int i=0; i<span.length; i++)
        {
            System.out.print(span[i] + " ");
        }
    }
}
