package Arrays;

public class StockBuySell {
    public static void stockBuySell(int prices[]){
        int buyingPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++){
            if(buyingPrice < prices[i]){
                int curr = prices[i] - buyingPrice;
                maxProfit = Math.max(maxProfit, curr);
            }else{
                buyingPrice = prices[i];
            }
        }
        System.out.println(maxProfit);
    }
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        stockBuySell(prices);
    }
}
