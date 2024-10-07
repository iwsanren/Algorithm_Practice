import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class permutations46 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        backtracking(nums,used);
        return result;
    }
    private void backtracking(int[] nums, int[] used){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i] == 1) continue;
            path.add(nums[i]);
            used[i] = 1;
            backtracking(nums,used);
            path.removeLast();
            used[i] = 0;
        }
    }
}
class permutations46Test {
    public static void main(String[] args) {
        permutations46 example = new permutations46();
        int[] nums = {4,6,8};
        List<List<Integer>> result = example.permute(nums);
        for(List<Integer> levels :result){
            System.out.print("[");
            for(int i : levels){
                System.out.print(i+" ");
            }
            System.out.println("]");
        }
    }
}
