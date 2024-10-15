public class distinctSubsequence {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();//subsequence
        int[][] dp = new int[len1+1][len2+1];
        //dp[i][0]: 以i-1为结尾的s子序列中出现空字符串的个数为1。
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    //分两种情况：
                    //1.使用s[i-1]来匹配，即用s[i-1]来匹配t[j-1]： dp[i-1][j-1]
                    //2.不使用s[i-1]来匹配，即在s[i-1]之前就已经匹配了完整的j字符串。
                    //System.out.println("i= "+i + ", j= "+ j + ", dp[i][j]= "+ dp[i][j] + ", dp[i-1][j-1]= "+ dp[i-1][j-1] + ",dp[i-1][j] = "+dp[i-1][j]);
                }else{
                    dp[i][j] =  dp[i-1][j];
                }
                //System.out.println("dp["+i+"]["+j+"] = "+dp[i][j]);
            }
        }
        return dp[len1][len2];
    }
}
class distinctSubsequenceTest {
    public static void main(String[] args) {
        distinctSubsequence example = new distinctSubsequence();
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(example.numDistinct(s,t));
    }
}