public class BuySellStocks_14 {
    public static int profitCalc(int [] prices) {
        int profit = 0;
        int buyPrice= prices[0];
        for (int i = 1; i < prices.length; i++) {
            buyPrice = Math.min(buyPrice, prices[i - 1]);
            profit = Math.max(profit, prices[i]- buyPrice);
        }

        return profit;
    }
    public static void main(String[] args) {
        int [] prices = {7, 6, 4,  3, 1};
        System.out.println(profitCalc(prices));   
    }
}
