public class longestCommonSub {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1+1][len2+1];
        int result = 0;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    //System.out.println("the same char is: " + text1.charAt(i-1));
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                if(dp[i][j] > 0){
                    result = dp[i][j];
                }
                //System.out.println("dp["+i+"]["+j+"] = "+dp[i][j]);
            }
        }
        return result;
    }
}
class longestCommonSubTest {
    public static void main(String[] args) {
        longestCommonSub example = new longestCommonSub();
        String text1 = "abc";
        String text2 = "cb";
        System.out.println(example.longestCommonSubsequence(text1,text2));
    }
}