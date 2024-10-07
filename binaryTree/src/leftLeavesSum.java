import java.util.List;

public class leftLeavesSum {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;//从父节点取数值，节点处返回0
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);
        int mid = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            mid = root.left.val;
        }
        return mid + leftSum + rightSum;
    }
}
class leftLeavesSumTest {
    public static void main(String[] args) {
        TreeBuilder tb = new TreeBuilder();
        TreeNode root = tb.buildTree();

        leftLeavesSum lls = new leftLeavesSum();
        int res = lls.sumOfLeftLeaves(root);
        System.out.println(res);
    }
}
