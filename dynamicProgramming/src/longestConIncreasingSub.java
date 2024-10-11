public class longestConIncreasingSub {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }

        int result = 1;
        for (int i = 1; i < len; i++) {
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            if(dp[i] > result){
                result = dp[i];
            }
            System.out.println("dp["+i+"] = "+dp[i]);
        }
        return result;
    }
}
class longestConIncreasingSubTest {
    public static void main(String[] args) {
        longestConIncreasingSub example = new longestConIncreasingSub();
        int[] nums = {1,3,5,4,7};
        System.out.println(example.findLengthOfLCIS(nums));

    }
}