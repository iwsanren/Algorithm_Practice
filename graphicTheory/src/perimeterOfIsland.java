import java.util.Scanner;

public class perimeterOfIsland {
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};//右下左上
    static int count = 0;

    public static void perimeterCal(int[][] grid, int x, int y){
        //no need of visited
        // visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

//            if(nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length){
//                continue;
//            }
//            //if (x,y) adjacent to sea
//            if(grid[nextX][nextY] == 0){
//                perimeter++;
//            }
//            if(grid[nextX][nextY] == 1 && !visited[nextX][nextY]){
//                dfs(grid,nextX,nextY,visited);
//            }

            //can be simplified as: meet boarder or sea, perimeter++
            if(nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length || grid[nextX][nextY] == 0){
                count++;
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        //boolean[][] visited = new boolean[n][m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1){
                    count = 0;
                    perimeterCal(grid,i,j);
                    result += count;
                }
            }
        }
        System.out.println(result);
    }
}
