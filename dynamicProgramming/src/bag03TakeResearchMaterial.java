import java.util.Scanner;

public class bag03TakeResearchMaterial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        int bagSpace = sc.nextInt();

        int[] weight = new int[type];
        int[] value = new int[type];

        for (int i = 0; i < type; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[] dp = new int[bagSpace+1];

        for (int i = 0; i < type; i++) {
            for (int j = weight[i]; j <= bagSpace; j++) {
                dp[j] = Math.max((dp[j-weight[i]] + value[i]),dp[j]);
            }
        }

        System.out.println(dp[bagSpace]);
    }
}
