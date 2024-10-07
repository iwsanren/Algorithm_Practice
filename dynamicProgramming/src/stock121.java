public class stock121 {
    public int maxProfit(int[] prices) {
        //if(prices.length == 1) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];//hold
        dp[0][1] = 0;//notHolding

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
//            System.out.println("dp["+ i + "][0] = " + dp[i][0]);
//            System.out.println("dp["+ i + "][1] = " + dp[i][1]);
        }

        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);

    }
}
class stock121Test {
    public static void main(String[] args) {
        stock121 example = new stock121();
        int[] prices = {7};
        System.out.println(example.maxProfit(prices));


    }
}