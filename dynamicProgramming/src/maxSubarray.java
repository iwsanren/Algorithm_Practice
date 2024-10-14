public class maxSubarray {
    public int maxSubArray(int[] nums) {
//        //solution1: greedy
//        int cur = 0;
//        int result = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            cur += nums[i];
//            result = Math.max(cur,result);
//            if(cur < 0) cur = 0;
//        }
//        return result;

        //solution2: dynamic programming
        int len = nums.length;
        int[] dp = new int[len + 1];
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
//            int cur = dp[i-1] + nums[i-1];
//            if(cur > 0){
//                dp[i] = cur;
//            }else{
//                dp[i] = 0;
//            }
            dp[i] = Math.max(dp[i-1]+nums[i-1],nums[i-1]);
            if(dp[i] > result){
                result = dp[i];
            }
        }
        return result;
    }
}
class maxSubarrayTest {
    public static void main(String[] args) {
        maxSubarray example = new maxSubarray();
        int[] nums = {-1};
        System.out.println(example.maxSubArray(nums));
    }
}