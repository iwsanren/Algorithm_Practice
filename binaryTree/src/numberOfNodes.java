public class numberOfNodes {
    //数任意二叉树组都可以用这个方法
    public int anyTreeNodes(TreeNode node){
        if(node == null) return 0;
        int leftCount = anyTreeNodes(node.left);
        int rightCount = anyTreeNodes(node.right);
        int result = leftCount + rightCount + 1;
        return result;
    }
    //every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
    public int completeTreeNodes(TreeNode node){
        if(node == null) return 0;
        TreeNode left = node.left;
        TreeNode right = node.right;
        int leftLevel = 0;
        int rightLevel = 0;
        while(left != null){
            left = left.left;
            leftLevel++;
        }
        while(right != null){
            right = right.right;
            rightLevel++;
        }
        if(rightLevel == leftLevel) return (2 << leftLevel) - 1;

        int leftNum = completeTreeNodes(node.left);
        int rightNum = completeTreeNodes(node.right);
        return leftNum + rightNum + 1;
    }
}
class numberOfNodesTest {

}