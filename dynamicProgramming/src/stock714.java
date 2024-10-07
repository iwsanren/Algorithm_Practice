public class stock714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //持有
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            //不持有
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);

    }
}
class stock714Test {
    public static void main(String[] args) {
        stock714 example = new stock714();
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println(example.maxProfit(prices,fee));
    }
}