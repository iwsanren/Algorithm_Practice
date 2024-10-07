public class targetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        //如果target的绝对值大于sum，那么无解
        if ((sum + target) % 2 == 1 || Math.abs(target) > sum) return 0;

        int capacity = (sum + target) >> 1;

        int[] dp = new int[capacity + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = capacity; j >= nums[i]; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println("dp["+i+"] = "+dp[i]);
        }
        return dp[capacity];
    }
}

class targetSumTest {
    public static void main(String[] args) {
        targetSum example = new targetSum();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(example.findTargetSumWays(nums, target));
    }
}