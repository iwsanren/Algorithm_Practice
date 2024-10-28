import java.util.Scanner;

public class largestIslandArea {
    static int area;

    public static void dfs(boolean[][] visited, int x, int y, int[][] grid){
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if(nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length){
                continue;
            }

            if(!visited[nextX][nextY] && grid[nextX][nextY] == 1){
                area++;
                visited[nextX][nextY] = true;
                dfs(visited,nextX,nextY,grid);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//line
        int m = sc.nextInt();//row
        //store the land and sea
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(grid[i][j]+" ");
//            }
//            System.out.println();
//        }

        boolean[][] visited = new boolean[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j] == 1){
                    area = 1;
                    visited[i][j] = true;
                    dfs(visited,i,j,grid);
                    ans = Math.max(ans,area);
                }
            }
        }

        System.out.println(ans);
    }

}
