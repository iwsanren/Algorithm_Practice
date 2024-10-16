public class palindromicSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (boolean[] b1 : dp) {
            for (boolean b2 : b1) {
                b2 = false;
            }
        }

        int result = 0;
        //遍历顺序由递推公式决定。
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                //仅考虑两端相等的情况。
                if(s.charAt(i) == s.charAt(j)){
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        result++;
                        System.out.println(result + " i: "+ i + ", j: " + j + s.substring(i,j+1));
                    }else{
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            result++;
                            System.out.println(result + "i: "+ i + ", j: " + j + s.substring(i,j+1));
                        }
                    }
                }
            }
        }
        return result;
    }
}
class palindromicSubstringsTest {
    public static void main(String[] args) {
        palindromicSubstrings example = new palindromicSubstrings();
        String s = "aaaaa";
        System.out.println(example.countSubstrings(s));
    }
}