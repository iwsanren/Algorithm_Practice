public class coinSolution {
    public int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[amount + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = max;
        }

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //when initialize the dp as Max_VALUE:
                //Only if dp[i - coins[j]] has been rewrite, this loop is necessary
//                if (i >= coins[j] && dp[i - coins[j]] != max) {
//                    dp[i] = Math.min((dp[i - coins[j]] + 1), dp[i]);
//                }

                //when initialize the dp as amount+1:
                if (i >= coins[j]) {
                    dp[i] = Math.min((dp[i - coins[j]] + 1), dp[i]);
                }

            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}

class coinSolutionTest {
    public static void main(String[] args) {
        coinSolution example = new coinSolution();
        int[] coins = {5,7};
        int amount = 11;
        System.out.println(example.coinChange(coins, amount));
    }
}