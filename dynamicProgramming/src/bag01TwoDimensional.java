import java.util.Scanner;

public class bag01TwoDimensional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int bagCapacity = sc.nextInt();

        int[] materialSpace = new int[num];
        int[] materialValue = new int[num];

        for (int i = 0; i < num; i++) {
            materialSpace[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            materialValue[i] = sc.nextInt();
        }

//        int num = 6;
//        int bagCapacity = 3;
//
//        int[] materialSpace = {2,2,3,1,5,2};
//        int[] materialValue = {2,3,1,5,4,3};

        //dp初始化
        int[][] dp = new int[num][bagCapacity+1];
        //初始化第一行：有简洁的写法，即直接从materialSpace[0]开始遍历。如果它大于包的容量，则不进入循环。
        for (int i = materialSpace[0]; i <= bagCapacity; i++) {
            dp[0][i] = materialValue[0];
        }
        //初始化第一列：其实不用写，默认的初始值就是0

        for (int i = 1; i < num; i++) {
            for (int j = 0; j <= bagCapacity; j++) {
//                //不要第i个物品
//                int noI = dp[i-1][j];
//                //要第i个物品
//                int withI = dp[i-1][j-materialSpace[i]] + materialValue[i];
                if(materialSpace[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-materialSpace[i]] + materialValue[i]);
                }
            }
        }
//        for (int i = 0; i < num; i++) {
//            for (int j = 0; j <= bagCapacity; j++) {
//                System.out.print("dp["+i+"]["+j+"] = "+ dp[i][j]+"  ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[num-1][bagCapacity]);
    }
}
