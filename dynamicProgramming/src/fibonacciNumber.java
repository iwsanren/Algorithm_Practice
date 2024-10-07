public class fibonacciNumber {
    //完整版
    public int fib(int n) {
        if(n < 2) return n;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    //精简版：因为本质上只在操作三个数，所以不需要数组。
    public int fibCondensed(int n) {
        if(n < 2) return n;

        int a = 0;
        int b = 1;
        int c = a+b;

        for (int i = 2; i < n; i++) {
            a = b;
            b = c;
            c = a+b;
        }

        return c;
    }
}
