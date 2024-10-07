import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class maximumBT {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructNode(nums,0,nums.length);
    }
    public TreeNode constructNode(int[] nums, int start, int end) {
        if(end - start < 1) return null;
        if(end - start == 1)return new TreeNode(nums[start]);
        //前序遍历，中左右。先处理中
        //中:找到最大值后，将最大值设为根节点
        //题目中说了数组元素是大于0的。
        int index = start;
        int maxValue = nums[start];
        for (int i = start + 1; i < end; i++) {
            if(nums[i] > maxValue){
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(maxValue);
        //左
            node.left = constructNode(nums,start,index);
        //右
            node.right = constructNode(nums,index+1, end);
        return node;
    }
}
class maximumBTTest {
    public static void main(String[] args) {
        maximumBT mbt = new maximumBT();
        maximumBTTest test = new maximumBTTest();
        int[] nums = {3,2,1,6,0,5};
        TreeNode node = mbt.constructMaximumBinaryTree(nums);

        List<List<Integer>> list = test.levelOrder(node);
        for(List<Integer> levels :list){
            System.out.print("[");
            for(int num : levels){
                System.out.print(num+" ");
            }
            System.out.println("]");
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();//保存结果
        if(root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> levelNums = new LinkedList<>();//保存每一层的结果
            while(size > 0){
                TreeNode node = deque.peekFirst();
                levelNums.add(node.val);
                deque.pollFirst();//要记得把添加过的元素弹出！
                if(node.left != null) deque.offerLast(node.left);
                if(node.right != null) deque.offerLast(node.right);
                size--;
            }
            result.add(levelNums);
        }
        return result;
    }

}