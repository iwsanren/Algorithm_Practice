public class houseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        //如果只有一家，那么一定抢
        if(nums.length == 1) return nums[0];

        //初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        //本题不是背包问题，没有背包容量，无需考虑是先遍历背包还是先遍历物品
        for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.max((dp[i-2] + nums[i]),dp[i-1]);
        }

        return dp[nums.length - 1];
    }
}
class houseRobberTest {
    public static void main(String[] args) {
        houseRobber example = new houseRobber();
        int[] nums = {3};
        System.out.println(example.rob(nums));
    }
}