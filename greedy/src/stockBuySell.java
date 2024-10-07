public class stockBuySell {
    public int maxProfit(int[] prices) {
        //累计每天的正利润
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i-1],0);
        }
        return result;
    }
}
class stockBuySellTest {

}