public class balancedBT {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    private int getHeight(TreeNode node){
        if(node == null) return 0;
        int leftHeight = getHeight(node.left);
        //如果左叶子已经不平衡了 就一路返回-1.右叶子同理。
        if(leftHeight == -1) return -1;
        int rightHeight = getHeight(node.right);
        if(rightHeight == -1) return -1;
        //如果两边差值已经大于1了 就返回-1
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        //如果差值还没有大于1，则返回它的高度+1
        return Math.max(leftHeight,rightHeight) + 1;
    }
}
class balancedBTTest {
    public static void main(String[] args) {
        balancedBT bbt = new balancedBT();
        TreeBuilder bt = new TreeBuilder();
        TreeNode node = bt.buildTree();
        System.out.println(bbt.isBalanced(node));
    }
}
