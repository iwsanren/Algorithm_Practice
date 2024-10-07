import java.util.*;

public class nonDecSub {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return result;
    }
    private void backtracking(int[] nums, int startIndex){
        if(path.size() > 1){
            result.add(new ArrayList<>(path));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            //不取的元素：比path最后一个元素小的，同一级递归中出现过的
            if(path.size() != 0 && nums[i] < path.get(path.size()-1) || used.contains(nums[i])){
                continue;
            }
            used.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
class nonDecSubTest {
    public static void main(String[] args) {
        nonDecSub example = new nonDecSub();
        int[] nums = {4,6,8,8,7};
        List<List<Integer>> result = example.findSubsequences(nums);
        for(List<Integer> levels :result){
            System.out.print("[");
            for(int i : levels){
                System.out.print(i+" ");
            }
            System.out.println("]");
        }
    }
}