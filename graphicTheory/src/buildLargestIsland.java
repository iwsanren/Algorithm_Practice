import java.util.*;

public class buildLargestIsland {
    static int count;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    //replace visited with mark
    public static void dfs(int[][] grid, int x, int y, int mark) {
        count++;
        grid[x][y] = mark;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                continue;
            }
            //和（x,y)相连并且是未访问过的岛屿：
            if (grid[nextX][nextY] == 1) {
                dfs(grid, nextX, nextY, mark);
            }
        }
    }

    public static int calculateArea(int[][] grid, Map<Integer,Integer> islandArea, int x, int y){
        int area = 1;
        //用于记录四周是否有标记不同的岛屿
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length || grid[nextX][nextY] == 0) {
                continue;
            }
            //遍历过了
            if(set.contains(grid[nextX][nextY])){
                continue;
            }
            set.add(grid[nextX][nextY]);
            area += islandArea.get(grid[nextX][nextY]);
        }
        return area;
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
        //用于标记访问过的岛屿，并且匹配岛屿和面积
        int mark = 2;
        Map<Integer, Integer> islandArea = new HashMap<Integer, Integer>();
        //用于标记是否全是陆地
        boolean isAllLand = true;
        //遍历地图，标记访问过的陆地，并且匹配它们的面积
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    isAllLand = false;
                }
                //出现未访问过的陆地
                if (grid[i][j] == 1) {
                    count = 0;
                    dfs(grid, i, j, mark);
                    islandArea.put(mark, count);
                    //为下一组记号做准备
                    mark++;
                }
            }
        }
        int result = 0;
        int area = 0;
        //继续标记地图，把每一个海洋变成陆地后看它们链接陆地的面积
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    area = calculateArea(grid,islandArea,i,j);
                    result = Math.max(result,area);
                }
            }
        }
        if(isAllLand) result = m * n;
        System.out.println(result);
    }
}
