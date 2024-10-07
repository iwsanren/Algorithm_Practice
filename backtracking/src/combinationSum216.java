import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combinationSum216 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,0,1);
        return result;
    }
    private void backtracking(int k, int target, int sum, int startIndex){
        //剪枝
        if(sum > target) return;
        if(sum == target){
            if(path.size() == k){
                result.add(new LinkedList<>(path));
                return;
            }
        }
        for (int i = startIndex; i <= 9 - (k-path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backtracking(k, target, sum, i+1);
            sum -= i;
            path.removeLast();
        }
    }
}
class combinationSum216Test {
    public static void main(String[] args) {
        combinationSum216 example = new combinationSum216();
        List<List<Integer>> result = example.combinationSum3(3,10);
        for(List<Integer> levels :result){
            System.out.print("[");
            for(int nums : levels){
                System.out.print(nums+" ");
            }
            System.out.println("]");
        }
    }
}