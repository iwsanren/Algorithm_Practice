import java.util.*;

public class AccessibilityOfDirectedGraph {
    //store the next vertices pointed to by each vertex
    public static List<List<Integer>> adjList = new ArrayList<>();

    //deep first search
    public static void dfs(boolean[] visited, int key) {
        visited[key] = true;
        //get next list (if exist)
        List<Integer> nextKeys = adjList.get(key);
        for (int nextKey : nextKeys) {
            //if the next key hasn't been visited
            if (!visited[nextKey]) {
                dfs(visited, nextKey);
            }
        }
    }

    //broad first search
    public static void bfs(boolean[] visited, int key) {
        visited[key] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(key);

        while (!queue.isEmpty()) {
            int curKey = queue.poll();
            List<Integer> nextKeys = adjList.get(curKey);
            for (int nextKey : nextKeys) {
                if (!visited[nextKey]) {
                    queue.add(nextKey);
                    visited[nextKey] = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertices_num = sc.nextInt();
        int sides_num = sc.nextInt();

        //adjList need sides_num + 1 subLists, because it starts from 0 while the vertices start from 1.
        for (int i = 0; i <= sides_num; i++) {
            //initialize adjList
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < sides_num; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();

//            adjList.get(s - 1).add(t - 1);
            adjList.get(s).add(t);
        }

        boolean[] visited = new boolean[vertices_num+1];
        bfs(visited, 1);

        for (int i = 1; i <= vertices_num; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(1);
    }
}
