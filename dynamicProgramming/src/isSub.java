public class isSub {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        int[][] dp = new int[len1+1][len2+1];
        int result = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                if(dp[i][j] > result){
                    result = dp[i][j];
                }
            }
        }
        return result == len1;
    }
}
class isSubTest {
    public static void main(String[] args) {

    }
}