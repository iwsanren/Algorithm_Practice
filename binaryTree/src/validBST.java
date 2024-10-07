public class validBST {
    TreeNode max;
    //迭代法。使用中序遍历。
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        //左
        boolean left = isValidBST(root.left);
        if(!left) return false;
        // 中
        //无论是在遍历左子树还是右子树时，如果是二叉搜索树，将会优先遍历小数值的节点。
        if(max != null && max.val > root.val){
            return false;
        }
        max = root;//用于保存上一个节点
        //右
        boolean right = isValidBST(root.right);
        return right;
    }
}
class validBSTTest {
    public static void main(String[] args) {
        validBST example = new validBST();
        TreeBuilder tb = new TreeBuilder();
        TreeNode root = tb.buildTree();
        boolean isValidBST = example.isValidBST(root);
        System.out.println(isValidBST);
    }

}