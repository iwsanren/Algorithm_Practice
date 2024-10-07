public class onesAndZero {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        //iterate items first
        for (String s : strs) {
            int x = 0;
            int y = 0;
            //to get how many 0 and i in this element
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == '0') {
                    x++;
                } else {
                    y++;
                }
            }

            //and then iterate the bag
            for (int i = m; i >= x; i--) {
                for (int j = n; j >= y; j--) {
                    dp[i][j] = Math.max((dp[i - x][j - y] + 1), dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
}

class onesAndZeroTest {
    public static void main(String[] args) {
        onesAndZero example = new onesAndZero();
        String[] strs = {"10","0","1"};
        int m = 1;
        int n = 1;

        System.out.println(example.findMaxForm(strs,m,n));

    }
}