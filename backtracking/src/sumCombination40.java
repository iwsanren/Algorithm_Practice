import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class sumCombination40 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] used = new int[candidates.length];
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0,used);
        return result;
    }
    private void backtracking(int[] candidates, int target, int sum, int startIndex, int[] used){
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if(sum + candidates[i] > target) break;
            if(i > 0 && candidates[i] == candidates[i-1] && used[i-1] == 0) continue;
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = 1;
            backtracking(candidates,target,sum,i+1,used);
            path.removeLast();
            sum -= candidates[i];
            used[i] = 0;
        }
    }
}
class sumCombination40Test {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        sumCombination40 example = new sumCombination40();
        List<List<Integer>> result = example.combinationSum2(candidates,8);
        for(List<Integer> levels :result){
            System.out.print("[");
            for(int nums : levels){
                System.out.print(nums+" ");
            }
            System.out.println("]");
        }

    }
}