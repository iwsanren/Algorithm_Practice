import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums,0,nums.length-1);
    }
    //左闭右闭
    private TreeNode traversal(int[] nums,int left, int right){
        if(left > right) return null;
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums,left,mid-1);
        root.right = traversal(nums,mid+1,right);
        return root;
    }
}
class sortedArrayToBSTTest {
    public static void main(String[] args) {
        int[] nums = {-15,-13,-11,-10,-3,0,5,9,12,14,17};
        sortedArrayToBST example = new sortedArrayToBST();
        TreeNode root = example.sortedArrayToBST(nums);

        sortedArrayToBSTTest print = new sortedArrayToBSTTest();
        List<List<Integer>> list = print.levelOrder(root);
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