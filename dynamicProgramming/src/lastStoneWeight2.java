public class lastStoneWeight2 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum/2;

        int[] dp = new int[target+1];

        for (int i = 0; i < stones.length; i++) {
            //如果此时背包剩余容量小于待加入石头的重量，则没必要进入循环
            //If the remaining capacity of the backpack at this time is less than the weight of the stones to be added, there is no need to enter the loop
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-stones[i]] + stones[i]);
            }
        }

        //return Math.abs(dp[target]-(sum-dp[target]));
        return sum - 2*dp[target];
    }
}
class lastStoneWeight2Test{
    public static void main(String[] args) {
        lastStoneWeight2 example = new lastStoneWeight2();
        int[] nums = {31,26,33,21,40};
        System.out.println(example.lastStoneWeightII(nums));
    }
}