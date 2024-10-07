import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class subsets78 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return result;
    }
    private void backtracking(int[] nums, int startIndex){
        //收获结果
        result.add(new ArrayList<>(path));
        //终止条件
        if(startIndex > nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
            startIndex--;
        }
    }
}
class subsets78Test {
    public static void main(String[] args) {
        subsets78 example = new subsets78();
        int[] nums = {1,2,3};
        List<List<Integer>> result = example.subsets(nums);
        for(List<Integer> levels :result){
            System.out.print("[");
            for(int i : levels){
                System.out.print(i+" ");
            }
            System.out.println("]");
        }
    }
}