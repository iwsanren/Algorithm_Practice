import java.util.*;

public class redundantConnectionWithDIr {
    static int n;
    static int[] father = new int[1001];
    //initialization
    public static void init(){
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public static int find(int u){
//        if(find(u) == u){
//            return u;
//        }else{
//            father[u] = find(father[u]);
//            return father[u];
//        }
        return find(u) == u ? u : (father[u] = find(father[u]));
    }

    public static void join(int u, int v){
        u = find(u);
        v = find(v);
        if(u != v){
            father[v] = u;
        }
    }

    public static boolean isSame(int u, int v){
        u = find(u);
        v = find(v);
        return u == v;
    }

    //get edge make the sides into a loop
    public static void getRemoveEdge(List<int[]> edges){
        init();
        for (int i = 0; i < n; i++) {
            if(isSame(edges.get(i)[0],edges.get(i)[1])){
                System.out.println(edges.get(i)[0] + " " + edges.get(i)[1]);
                return;
            }else{
                join(edges.get(i)[0],edges.get(i)[1]);
            }
        }
    }

    //if a side has been deleted, whether the sides still can form a loop
    public static boolean isTreeAfterRemoveEdge(List<int[]> edges, int deleEdge){
        init();
        for (int i = 0; i < n; i++) {
            if(i == deleEdge) continue;
            if(isSame(edges.get(i)[0],edges.get(i)[1])){
                return false;
            }
            join(edges.get(i)[0],edges.get(i)[1]);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> edges = new ArrayList<>(); // 存储所有的边

        n = sc.nextInt(); // 顶点数
        int[] inDegree = new int[n + 1]; // 记录每个节点的入度
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt(); // 边的起点
            int t = sc.nextInt(); // 边的终点
            inDegree[t]++;
            edges.add(new int[]{s, t}); // 将边加入列表
        }

        List<Integer> vec = new ArrayList<>(); // 记录入度为2的边（如果有的话就两条边）
        // 找入度为2的节点所对应的边，注意要倒序，因为优先删除最后出现的一条边
        for (int i = n - 1; i >= 0; i--) {
            if (inDegree[edges.get(i)[1]] == 2) {
                vec.add(i);
            }
        }

        // 情况一、情况二
        if (vec.size() > 0) {
            // vec里的边已经按照倒叙放的，所以优先删 vec.get(0) 这条边
            if (isTreeAfterRemoveEdge(edges, vec.get(0))) {
                System.out.println(edges.get(vec.get(0))[0] + " " + edges.get(vec.get(0))[1]);
            } else {
                System.out.println(edges.get(vec.get(1))[0] + " " + edges.get(vec.get(1))[1]);
            }
            return;
        }

        // 处理情况三：明确没有入度为2的情况，一定有有向环，找到构成环的边返回即可
        getRemoveEdge(edges);
    }

}
