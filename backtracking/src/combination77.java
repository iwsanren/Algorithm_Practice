import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combination77 {
//    //完整版
//    List<List<Integer>> result = new ArrayList<>();
//    LinkedList<Integer> path = new LinkedList<>();
//    public List<List<Integer>> combine(int n, int k) {
//        backtracking(n,k,1);
//        return result;
//    }
//    //1.确认参数和返回值
//    private void backtracking(int n, int k, int startIndex){
//        //2.确认终止条件
//        if(path.size() == k){
////            for(int i : path){
////                System.out.print(i+" ");
////            }
////            System.out.println();
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        //3.回溯搜索的遍历过程
//        //for (int i = startIndex; i <= n; i++) {//未剪枝
//        for (int i = startIndex; i <= n - (k-path.size()) + 1; i++) {//剪枝版
//            path.add(i);
//            backtracking(n,k,i+1);
//            path.removeLast();
//        }
//    }
List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    private void combineHelper(int n, int k, int startIndex) {
        // 打印当前递归的状态
        System.out.println("Entering combineHelper with n=" + n + ", k=" + k + ", startIndex=" + startIndex + ", path=" + path);

        // 终止条件
        if (path.size() == k) {
            // 复制当前路径到结果中
            result.add(new ArrayList<>(path));
            // 打印找到的组合
            System.out.println("Found combination: " + path);
            return;
        }

        // 遍历所有可能的起始索引到n
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            // 递归调用，注意startIndex变为i+1，因为我们不重复选择同一个数字
            combineHelper(n, k, i + 1);
            path.removeLast(); // 回溯，撤销上一步的选择
        }

        // 离开递归的打印（可选，用于调试或理解递归返回时的状态）
        System.out.println("Exiting combineHelper with n=" + n + ", k=" + k + ", startIndex=" + startIndex + ", path=" + path);
    }

}
class combination77Test {
    public static void main(String[] args) {
        combination77 example = new combination77();
        List<List<Integer>> result = example.combine(7,4);
        for(List<Integer> levels :result){
            System.out.print("[");
            for(int nums : levels){
                System.out.print(nums+" ");
            }
            System.out.println("]");
        }

    }

}