public class stock188 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                //hold
                dp[i][j + 1] = Math.max((dp[i - 1][j + 1]), (dp[i - 1][j] - prices[i]));
                //unhold
                dp[i][j + 2] = Math.max((dp[i - 1][j + 2]), (dp[i - 1][j + 1] + prices[i]));
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                System.out.print("dp["+i+"]["+j+"] = " + dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[prices.length - 1][2 * k];
    }
}

class stock188Test {
    public static void main(String[] args) {
        stock188 example = new stock188();
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println(example.maxProfit(k,prices));
    }

}