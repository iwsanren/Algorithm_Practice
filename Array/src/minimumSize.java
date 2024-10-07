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

    //9.24 review
    public int minSubArrayLen2(int target, int[] nums) {
        int start = 0;
        int result = nums.length + 1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target){
                result = Math.min(result,i-start+1);
                sum -= nums[start];
                start++;
            }
        }

        return result == nums.length+1 ? 0 : result;
    }
}
class minimumSizeTest {
    public static void main(String[] args) {
        minimumSize example = new minimumSize();
        int[] nums = {1,4,4};
        int target = 4;
        System.out.println(example.minSubArrayLen2(target,nums));
    }

}