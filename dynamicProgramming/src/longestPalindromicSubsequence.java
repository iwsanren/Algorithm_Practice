public class longestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(i == j){
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = len-1; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                    //System.out.println("dp["+i+"]["+j+"] = "+dp[i][j]);
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    //System.out.println("dp["+i+"]["+j+"] = "+dp[i][j]);
                }
            }
        }

        return dp[0][len-1];
    }
}
class longestPalindromicSubsequenceTest {
    public static void main(String[] args) {
        longestPalindromicSubsequence example = new longestPalindromicSubsequence();
        String s = "abcfdcfbaaz";
        System.out.println(example.longestPalindromeSubseq(s));
    }
}