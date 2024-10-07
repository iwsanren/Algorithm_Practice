public class uniquePath {
    public int uniquePaths(int m, int n) {
        //这里初始化二维数组一定要把第二个维度也初始化，否则无法初始化dp。
        int[][] dp = new int[m + 1][n + 1];

        if (m == 1 || n == 1) return 1;

        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}

class uniquePathTest {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        uniquePath example = new uniquePath();
        System.out.println(example.uniquePaths(m, n));
    }
}