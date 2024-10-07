//本题也是104. Maximum Depth of Binary Tree，和层序遍历不同的是，用的是迭代遍历。
public class depthBT {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int height = Math.max(leftHeight,rightHeight) +1;
        return height;
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        //如果只有一个叶子节点不为空，那么就返回该节点的深度+1；
        if(root.left != null && root.right == null) return leftDepth+1;
        if(root.left == null && root.right != null) return rightDepth+1;
        return Math.min(leftDepth,rightDepth) + 1;
    }

}
class depthBTTest {
    public static void main(String[] args) {
        depthBT dbt = new depthBT();
        TreeBuilder tb = new TreeBuilder();
        TreeNode root = tb.buildTree();
        int height = dbt.minDepth(root);
        System.out.println(height);
    }
}
