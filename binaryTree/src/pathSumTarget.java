import java.util.LinkedList;
import java.util.List;

public class pathSumTarget {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        // 从当前节点开始计算路径和（回溯）
        int currentSum = targetSum - root.val;
        // 如果是叶子节点，并且路径和为0，则返回true
        if (root.left == null && root.right == null) {
            return currentSum == 0;
        }
        // 递归检查左子树和右子树
        //return hasPathSum(root.left, currentSum) || hasPathSum(root.right, currentSum);
        boolean flagLeft = hasPathSum(root.left, currentSum);
        boolean flagRight = hasPathSum(root.right, currentSum);
        return flagLeft || flagRight;
    }
}
class pathSumTargetTest {
    public static void main(String[] args) {
        TreeBuilder tb = new TreeBuilder();
        TreeNode root = tb.buildTree();

        pathSumTarget example = new pathSumTarget();
        boolean i  = example.hasPathSum(root,16);
        System.out.println(i);
    }
}
