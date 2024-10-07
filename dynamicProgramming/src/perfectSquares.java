import java.util.Arrays;

public class perfectSquares {
    public int numSquares(int n) {
        int max = n + 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i < Math.sqrt((double) n) + 1; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min((dp[j - i * i] + 1), dp[j]);
            }
        }
        return dp[n];
    }
}

class perfectSquaresTest {
    public static void main(String[] args) {
        perfectSquares example = new perfectSquares();
        System.out.println(example.numSquares(41));

    }
}