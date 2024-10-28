import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class allPath98 {
    //深搜三部曲-1：确认递归函数，参数
    static List<List<Integer>> result = new ArrayList<>();// 收集路径
    static List<Integer> path = new ArrayList<>(); // 0节点到终点的路径
    // x：目前遍历的节点
    // graph：存当前的图
    // n：终点
    public static void dfs(int[][] graph, int x, int n) {
    //深搜三部曲-2：确认终止条件
    //什么时候我们就找到一条路径了？当目前遍历的节点 为 最后一个节点 n 的时候 就找到了一条 从出发点到终止点的路径。
        if(x == n){
            //注意--------------------------------
            //需要新建一个path对象传入！
            result.add(new ArrayList<>(path));
            return;
        }
        //深搜三部曲-3：处理目前搜索节点出发的路径
        //接下来是走 当前遍历节点x的下一个节点
        for (int i = 1; i <= n; i++) { // 遍历节点x链接的所有节点
            if(graph[x][i] == 1){ // 找到 x指向的节点，就是节点i
                path.add(i);
                //下一层递归
                dfs(graph,i,n);
                //回溯
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n个节点
        int m = sc.nextInt(); // m条路径

        // 节点编号从1到n，所以申请 n+1 这么大的数组
        int[][] graph = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            int s = sc.nextInt();
            int t = sc.nextInt();
            // 使用邻接矩阵表示无向图，1 表示 s 与 t 是相连的
            graph[s][t] = 1;
        }
        path.add(1); // 无论什么路径已经是从1节点出发
        dfs(graph, 1, n); // 开始遍历

        if(result.isEmpty()){
            System.out.println(-1);
        }
        for(List<Integer> path : result){
            for (int i = 0; i < path.size() - 1; i++) {
                System.out.print(path.get(i) + " ");
            }
            //因为最后一个数字后面没有空格，所以要单独写
            System.out.println(path.get(path.size() - 1));
        }
    }
}
class allPath{
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length - 1;
        path.add(0);
        dfs(graph,0,n);

        return result;
    }
    //确认参数
    public void dfs(int[][] graph, int x, int n){
        //终止条件：
        if(x == n){
            result.add(new ArrayList<>(path));
            return;
        }
        //遍历节点x，把它指向的节点y加入path。
        for (int y : graph[x]) {
            path.add(y);
            //传入y，以继续遍历节点x所指向的节点y
            dfs(graph, y, n);
            path.remove(path.size()-1);
        }
    }
}





















