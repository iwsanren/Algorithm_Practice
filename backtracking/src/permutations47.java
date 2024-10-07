import java.util.*;

public class permutations47 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] used = new int[nums.length];
        backtracking(nums,used);
        return result;
    }
    private void backtracking(int[] nums, int[] used){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> usedSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(used[i] != 0 || usedSet.contains(nums[i])) continue;

            path.add(nums[i]);
            used[i] = 1;
            usedSet.add(nums[i]);

            backtracking(nums,used);

            path.removeLast();
            used[i] = 0;
        }
    }
}
class permutations47Test {
    public static void main(String[] args) {
        permutations47 example = new permutations47();
        int[] nums = {4,4,1,4,4};
        List<List<Integer>> result = example.permuteUnique(nums);
        for(List<Integer> levels :result){
            System.out.print("[");
            for(int i : levels){
                System.out.print(i+" ");
            }
            System.out.println("]");
        }
    }
}