public class uniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1 ) return 0;
        //if(m == 1 || n == 1) return 1;//这次不可以简单地这样剪枝了，因为这其中可能有障碍，那最后还是0

        int[][] dp = new int[m][n];

//        for (int i = 0; i < m ; i++) {
//            if(obstacleGrid[i][0] == 1){
//                dp[i][0] = 0;
//            }else{
//                dp[i][0] = 1;
//            }
//        }
        //可精简为：
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        //下同
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
class uniquePath2Test {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},{0,1,0},{0,0,0},{0,0,1}
        };
        uniquePath2 example = new uniquePath2();
        System.out.println(example.uniquePathsWithObstacles(obstacleGrid));
    }
}











