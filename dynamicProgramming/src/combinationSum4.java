public class combinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        //先遍历物品，再遍历背包可以得到组合数
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = nums[i]; j <= target; j++) {
//                dp[j] += dp[j-nums[i]];
//            }
//        }
        //先遍历背包，再遍历物品可以得到排列数
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i >= nums[j]){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }

        return dp[target];
    }
}
class combinationSum4Test {
    public static void main(String[] args) {
        combinationSum4 example = new combinationSum4();
        int[] nums = {1,2,3};
        int target = 4;

        System.out.println(example.combinationSum4(nums,target));


    }
}