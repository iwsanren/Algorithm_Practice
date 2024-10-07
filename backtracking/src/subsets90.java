import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class subsets90 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        backtracking(nums,0,used);
        return result;
    }
    private void backtracking(int[] nums, int startIndex, int[] used){
        result.add(new ArrayList<>(path));

        if(startIndex > nums.length) return;

        for (int i = startIndex; i < nums.length; i++) {
            //used[i-1] == 0意味着前一位重复元素之前没有在同一层遍历上使用过，这种情况需要做去重。直接continue，不处理后面的数据即可。
            if(i > 0 && nums[i] == nums[i-1] && used[i-1] == 0) continue;
            path.add(nums[i]);
            used[i] = 1;
            backtracking(nums,i+1,used);
            path.removeLast();
            startIndex--;
            used[i] = 0;
        }
    }
}
class subsets90Test {
    public static void main(String[] args) {
        subsets90 example = new subsets90();
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> result = example.subsetsWithDup(nums);
        for(List<Integer> levels :result){
            System.out.print("[");
            for(int i : levels){
                System.out.print(i+" ");
            }
            System.out.println("]");
        }
    }
}