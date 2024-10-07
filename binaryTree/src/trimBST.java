public class trimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(low > root.val){
            TreeNode right = trimBST(root.right,low,high);
            //将节点返回根节点
            return right;
        }else if(high < root.val){
            TreeNode left = trimBST(root.left,low,high);
            return left;
        }
        root.left = trimBST(root.left,low, high);
        root.right = trimBST(root.right,low, high);
        return root;
    }
}
class trimBSTTest {
    public static void main(String[] args) {
        TreeBuilder tb = new TreeBuilder();
        TreeNode root1 = tb.buildTree();

        trimBST example = new trimBST();
        example.trimBST(root1,3,7);

    }
}