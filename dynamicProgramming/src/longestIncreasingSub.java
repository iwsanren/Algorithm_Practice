public class longestIncreasingSub {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        int result = 1;
        for (int i = 1; i < len; i++) {
            //遍历从1-i所有的dp[i]，做比较
            //这里j要从0开始遍历！nums[0]也要被比较到
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            //本题返回的不是末尾元素，因为dp[i]表示以nums[i]结尾的最长递增子序。最长递增子序列不一定会以最后一个元素结尾。
            if (dp[i] > result){
                result = dp[i];
            }
//            System.out.println("dp["+i+"] = "+dp[i]);
        }
        return result;
    }
}

class longestIncreasingSubTest {
    public static void main(String[] args) {
        longestIncreasingSub example = new longestIncreasingSub();
        int[] nums = {7,7,7,7,7,7,7};
        System.out.println(example.lengthOfLIS(nums));
    }

}