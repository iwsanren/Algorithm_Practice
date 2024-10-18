import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElementCir {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        //剪枝
        if(len <= 1) return new int[]{-1};

        int[] result = new int[len];
        Arrays.fill(result,-1);//初始化为-1
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        //模拟两个数组连在一起
        for (int i = 0; i < len * 2; i++) {
            //通过取模防止下标溢出
            int index = i % nums.length;
            if(nums[index] <= nums[stack.peek()]){
                stack.push(index);
            }else{
                while(!stack.isEmpty() && nums[index] > nums[stack.peek()]){
                    result[stack.peek()] = nums[index];
                    stack.pop();
                }
                stack.push(index);
            }
        }
        return result;
    }
}
class nextGreaterElementCirTest {
    public static void main(String[] args) {

    }
}