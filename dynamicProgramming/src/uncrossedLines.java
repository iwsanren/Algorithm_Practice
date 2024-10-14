//similar to 1143. Longest Common Subsequence
public class uncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int result = 0;
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    //System.out.println("dp["+i+"]["+j+"] = "+dp[i][j]);
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
                if(dp[i][j] > result){
                    result = dp[i][j];
                }
            }
        }
        return result;
    }
}
class uncrossedLinesTest {
    public static void main(String[] args) {
        uncrossedLines example = new uncrossedLines();
        int[] nums1 = {1,4,2};
        int[] nums2 = {1,2,4};
        System.out.println(example.maxUncrossedLines(nums1,nums2));
    }
}