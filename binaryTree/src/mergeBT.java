public class mergeBT {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }
}
class mergeBTTest {
    public static void main(String[] args) {
        TreeBuilder tb = new TreeBuilder();
        TreeNode root1 = tb.buildTree();
        TreeNode root2 = tb.buildTree();

        mergeBT mbt = new mergeBT();
        TreeNode root = mbt.mergeTrees(root1,root2);

    }
}
