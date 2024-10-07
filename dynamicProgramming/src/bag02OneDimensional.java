import java.util.Scanner;

public class bag02OneDimensional {
    public static void main(String[] args) {
//        int materialNum = 6;
//        int capacity = 6;
//
//        int[] weight = {2,2,3,1,5,2};
//        int[] value = {2,3,1,5,4,3};

        //get data

        Scanner sc = new Scanner(System.in);
        int materialNum = sc.nextInt();
        int capacity = sc.nextInt();

        int[] weight = new int[materialNum];
        int[] value = new int[materialNum];

        for (int i = 0; i < materialNum; i++) {
            weight[i] = sc.nextInt();
        }

        for (int i = 0; i < materialNum; i++) {
            value[i] = sc.nextInt();
        }

        int[] dp = new int[capacity+1];//当背包容量为i时，包内物品的最大价值为dp[i]

        for (int i = 0; i < materialNum; i++) {
            for (int j = capacity; j >= weight[i]; j--) {
                int withoutI = dp[j];
                int withI = dp[j-weight[i]] + value[i];
                dp[j] = Math.max(withoutI,withI);
                //System.out.println("dp["+i+"]["+j+"]"+" = " + dp[j]);
            }
        }

        System.out.println(dp[capacity]);

    }
}
