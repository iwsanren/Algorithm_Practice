import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class combinationSum39 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0);
        return result;
    }
    private void backtracking(int[] candidates, int target, int sum,int startIndex){
//        if(sum > target){
//            return;
//        }
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            //将上面的if(sum > target) return;替换为这句以后，代码效率大大提高了。
            if(sum + candidates[i] > target) break;
            path.add(candidates[i]);
            sum += candidates[i];
            //这里允许元素重复，所以无需i++
            backtracking(candidates,target,sum,i);
            sum -= candidates[i];
            path.removeLast();
        }

    }
}
class combinationSum39Test {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        combinationSum39 example = new combinationSum39();
        List<List<Integer>> result = example.combinationSum(candidates,8);
        for(List<Integer> levels :result){
            System.out.print("[");
            for(int nums : levels){
                System.out.print(nums+" ");
            }
            System.out.println("]");
        }
    }
}