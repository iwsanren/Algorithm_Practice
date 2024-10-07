public class jumpGame55 {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i+nums[i],cover);
            if(cover >= nums.length-1) return true;
        }
        return false;
    }
}
class jumpGame55Test {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        jumpGame55 example = new jumpGame55();
        System.out.println(example.canJump(nums));
    }
}