public class maxRepeatedSubLen {
    public int findLength(int[] nums1, int[] nums2) {
        //刚开始自己写的一些鱼唇代码
//        int[] numsL;
//        int[] numsS;
//
//        if(len2 > len1){
//            numsL = nums2;
//            numsS = nums1;
//            int temp = len1;
//            len1 = len2;
//            len2 = temp;
//         }else{
//            numsL = nums1;
//            numsS = nums2;
//        }
//
//        int[] dp = new int[len1];
//
//        for (int i = 0; i < len1; i++) {
//            for (int j = 0; j < len2; j++) {
//
//            }
//        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1+1][len2+1];
        int result = 0;//注意，这里的result不可以初始化为1.因为两个数组可能没有一个元素相等！
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;//如果相等，则回溯到两个数组都往前退一位后，再+1
                }
                if(dp[i][j] > result){
                    result = dp[i][j];
                }
                System.out.println("dp["+i+"]["+j+"] = "+dp[i][j]);
            }
        }
        return result;

    }

}
class maxRepeatedSubLenTest{
    public static void main(String[] args) {
        maxRepeatedSubLen example = new maxRepeatedSubLen();
        int[] nums1 = {70,39,25,40,7};
        int[] nums2 = {25,39,40,40,7};
        System.out.println(example.findLength(nums1,nums2));
    }

}