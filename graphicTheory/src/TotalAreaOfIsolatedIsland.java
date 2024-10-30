import java.util.Scanner;

public class TotalAreaOfIsolatedIsland {
    //deep first search
    static int count;

    public static void dfs(int x, int y, int[][] grid) {
        // enter from edges, turn islands linked to edges to 0
        grid[x][y] = 0;
        // the count will clear after searching from edges
        count++;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                continue;
            }
            //encounter the sea, no need to modify
            if (grid[nextX][nextY] == 0) {
                continue;
            }
            dfs(nextX, nextY, grid); // keep searching, turn islands not isolated to 0.
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // line
        int m = sc.nextInt(); // row

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(grid[i][j] + " ");
//            }
//            System.out.println();
//        }

        //search from edge left and edge right
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid);
            }
            if (grid[i][m - 1] == 1) {
                dfs(i, m - 1, grid);
            }
        }

        //search from bottom and top
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                dfs(0, i, grid);
            }
            if (grid[n - 1][i] == 1) {
                dfs(n - 1, i, grid);
            }
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1){
                    dfs(i, j, grid);
                }
            }
        }
        System.out.println(count);
    }
}
