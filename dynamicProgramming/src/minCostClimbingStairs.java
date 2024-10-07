public class minCostClimbingStairs {
    public minCostClimbingStairs() {    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min((dp[i-1]+cost[i-1]),(dp[i-2]+cost[i-2]));
        }
        return dp[cost.length] ;
    }
}
class minCostClimbingStairsTest {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};

        minCostClimbingStairs example = new minCostClimbingStairs();
        System.out.println(example.minCostClimbingStairs(cost));
    }
}