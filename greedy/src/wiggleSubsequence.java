public class wiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1)return nums.length;

        int preDifference = 0;
        int curDifference = 0;
        //头节点算上，不遍历它
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            curDifference = nums[i] - nums[i-1];
            if((preDifference >= 0 && curDifference < 0)||(preDifference <= 0 && curDifference > 0)){
                result++;
                preDifference = curDifference;
            }
        }
        return result;
    }
}
class wiggleSubsequenceTest {
    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,13,13,15,10,5,16,8};
        wiggleSubsequence example = new wiggleSubsequence();
        System.out.println(example.wiggleMaxLength(nums));
    }
}