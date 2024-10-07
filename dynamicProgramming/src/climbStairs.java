import java.util.Scanner;

public class climbStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stairs = sc.nextInt();
        int steps = sc.nextInt();

        int[] dp = new int[stairs+1];
        dp[0] = 1;

        for (int i = 0; i <= stairs; i++) {
            for (int j = 1; j <= steps; j++) {
                if(i >= j){
                    dp[i] += dp[i-j];
                }
            }
        }
        System.out.println(dp[stairs]);
    }
}

