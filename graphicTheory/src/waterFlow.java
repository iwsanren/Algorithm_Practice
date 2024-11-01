import java.util.Scanner;

public class waterFlow {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        //结束条件要记得加
        if(visited[x][y] == true){
            return;
        }
        visited[x][y] = true;//访问过即为true
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                continue;
            }
            //从低向高遍历
            if (grid[x][y] > grid[nextX][nextY]) {
                continue;
            }

            dfs(grid, visited, nextX, nextY);
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

        boolean[][] visited_first = new boolean[n][m];// left and top boarder
        boolean[][] visited_second = new boolean[n][m];// right and bottom boarder

        //top and bottom boarder
        for (int i = 0; i < m; i++) {
            dfs(grid,visited_first,0,i);
            dfs(grid,visited_second,n-1,i);
        }

        //left and right boarder
        for (int i = 0; i < n; i++) {
            dfs(grid,visited_first,i,0);
            dfs(grid,visited_second,i,m-1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited_first[i][j] && visited_second[i][j]){
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}
