import java.util.Arrays;

public class houseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int length = nums.length;
        int[] arr0 = Arrays.copyOfRange(nums, 0, (length - 1));
        int[] arr1 = Arrays.copyOfRange(nums, 1, (length));

        int rob0 = robbing(Arrays.copyOfRange(nums, 0, (length - 1)));
        int robL = robbing(Arrays.copyOfRange(nums, 1, (length)));

//        for (int i = 0; i < arr0.length; i++) {
//            System.out.print("arr0["+i+"] = "+arr0[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < arr1.length; i++) {
//            System.out.print("arr1["+i+"] = "+arr1[i] + " ");
//        }

        return Math.max(rob0, robL);
    }

    public int robbing(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max((dp[i - 2] + nums[i]), dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

}

class houseRobber2Test {
    public static void main(String[] args) {
        houseRobber2 example = new houseRobber2();
        int[] nums = {2, 4};
        System.out.println(example.rob(nums));
    }
}