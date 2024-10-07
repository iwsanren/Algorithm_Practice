public class maxSubarray {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            result = Math.max(cur,result);
            if(cur < 0) cur = 0;
        }
        return result;
    }
}
class maxSubarrayTest {
    public static void main(String[] args) {

    }
}