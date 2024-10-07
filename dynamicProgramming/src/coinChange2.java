public class coinChange2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j-coins[i]];
//                System.out.print("coinIndex: " + i + ", coinDenominations: " + coins[i] +
//                        ", bagCapacity: " + j + ", methods: " + dp[j] + "\t");
            }
            //System.out.println();
        }

        return dp[amount];
    }
}
class coinChange2Test {
    public static void main(String[] args) {
        coinChange2 example = new coinChange2();
        int amount = 6;
        int[] coins = {7,4,5};
        System.out.println(example.change(amount,coins));

    }
}