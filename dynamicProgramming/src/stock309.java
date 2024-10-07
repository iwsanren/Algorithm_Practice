public class stock309 {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        int[][] dp = new int[l][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;

        for (int i = 1; i < l; i++) {
            //dp`[i][0]:持有股票(1.继续持有；2.前一天是冷冻期，第i天买了股票；3.前一天处于保持卖出股票的状态，第i天新买了股票)
            //dp`[i][1]:保持卖出股票的状态（1.延续前一天；2.前一天是冷冻期）
            //dp`[i][2]:第i天卖出了股票
            //dp`[i][3]:冷冻期（冷冻期的前一天一定是卖出股票的状态）
            dp[i][0] = Math.max(Math.max((dp[i-1][0]),dp[i-1][3] - prices[i]),dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }
        int max = 0;
        for (int i = 0; i < dp[l -1].length; i++) {
            if(dp[l -1][i] > max){
                max = dp[l -1][i];
            }
        }
        return max;
    }
}
class stock309Test {
    public static void main(String[] args) {
        stock309 example = new stock309();
        int[] prices = {1};
        System.out.println(example.maxProfit(prices));
    }
}