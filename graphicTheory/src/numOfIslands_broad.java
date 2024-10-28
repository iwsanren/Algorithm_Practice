import java.util.*;

public class numOfIslands_broad {
    public static void bfs(boolean[][] visited, int x, int y, int[][] grid){
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        //遇到就标为true
        // 否则出队时才标记的话会导致重复访问，比如下方节点会在右下顺序的时候被第二次访问入队
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int curX = queue.peek()[0];
            int curY = queue.poll()[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];

                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                    continue;
                }

                if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});//未遍历过，加入进去
                }
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
                    ans++;
                    visited[i][j] = true;
                    bfs(visited,i,j,grid);
                }
            }
        }

        System.out.println(ans);

    }
}
