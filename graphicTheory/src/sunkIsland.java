import java.util.Scanner;

public class sunkIsland {
    public static void dfs(int x, int y, int[][] grid){
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        //mark non-isolated island as 2
        grid[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if(nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length){
                continue;
            }

            if(grid[nextX][nextY] == 1){
                dfs(nextX,nextY,grid);
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

        //left and right
        for (int i = 0; i < n; i++) {
            if(grid[i][0] == 1){
                dfs(i,0,grid);
            }
            if(grid[i][m-1] == 1){
                dfs(i,m-1,grid);
            }
        }

        //top and bottom
        for (int i = 0; i < m; i++) {
            if(grid[0][i] == 1){
                dfs(0,i,grid);
            }
            if(grid[n-1][i] == 1){
                dfs(n-1,i,grid);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 0){
                    continue;
                }else{
                    grid[i][j]--;
                }
            }
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        for (int j = 0; j < m; j++) {
            System.out.print(grid[n-1][j] + " ");
        }
    }
}
