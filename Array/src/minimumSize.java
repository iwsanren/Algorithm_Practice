public class minimumSize {
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int result = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= target){
//                int length =  i - start + 1;
//                result = Math.min(length,result);
                //simplify:
                result = Math.min(i-start+1,result);
                sum -= nums[start];
                start++;
            }
        }
//        if(result == nums.length + 1) return 0;
//        else return result;
        //simplify:
        return result == nums.length + 1 ? 0:result;
    }
}
