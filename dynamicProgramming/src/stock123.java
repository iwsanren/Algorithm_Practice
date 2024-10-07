public class stock123 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
            System.out.println("prices[" + i + "] = " + prices[i] + "   ");
            System.out.print("dp[" + i + "][0] = " + dp[i][0] + "   ");
            System.out.print("dp[" + i + "][1] = " + dp[i][1] + "   ");
            System.out.print("dp[" + i + "][2] = " + dp[i][2] + "   ");
            System.out.print("dp[" + i + "][3] = " + dp[i][3] + "   ");
            System.out.println("dp[" + i + "][4] = " + dp[i][4]);

        }

//        int max = dp[0][0];
//        for (int i = 0; i < 5; i++) {
//            max = Math.max(max,dp[prices.length-1][i]);
//        }

        return dp[prices.length - 1][4];

    }
}

class stock123Test {
    public static void main(String[] args) {
        stock123 example = new stock123();
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(example.maxProfit(prices));
    }
}