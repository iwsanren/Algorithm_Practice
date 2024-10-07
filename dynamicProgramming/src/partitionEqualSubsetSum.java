public class partitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum  += nums[i];
        }
        if(sum%2 == 1) return false;
        int target = sum/2;

        int[] dp = new int[target + 1];
        //先遍历物品，后遍历背包
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
//                int withI = dp[j - nums[i]] + nums[i];
//                int withoutI = dp[j];
                dp[j] = Math.max(dp[j - nums[i]] + nums[i],dp[j]);
            }
        }
        return dp[target] == target;
    }
}
class partitionEqualSubsetSumTest{
    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        partitionEqualSubsetSum example = new partitionEqualSubsetSum();
        System.out.println(example.canPartition(nums));

    }
}