public class insertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            //任何数字都可以插入二叉搜索树的叶子节点，无需改变二叉树结构。
            TreeNode node = new TreeNode(val);
            return node;
        }
        //如果当前节点的值大于待插入值，则向左寻找。
        if(root.val > val){
            root.left = insertIntoBST(root.left,val);
        //如果当前节点的值小于待插入值，则向右寻找。
        }else if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        }
        //如果传入的节点不为空，则直接返回当前节点到上一层。
        return root;
    }
}
class insertIntoBSTTest {
    public static void main(String[] args) {
        TreeBuilder tb = new TreeBuilder();
        TreeNode root1 = tb.buildTree();

        insertIntoBST example = new insertIntoBST();
        example.insertIntoBST(root1,5);
    }
}