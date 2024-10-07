public class houseRobber3 {
    public int rob(TreeNode root) {
        int[] arr = robbing(root);
        return Math.max(arr[0],arr[1]);
    }
    public int[] robbing(TreeNode node){
        int[] arr = new int[2];
        //中
        //若当前节点为空，则偷不偷都没钱，返回0
        if(node == null) return arr;
        //左
        int[] left = robbing(node.left);
        //右
        int[] right = robbing(node.right);

        arr[1] = node.val + left[0] + right[0];//偷当前节点，则返回当前节点金额和不偷左右子节点获得的最大金额
        arr[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);//不偷当前节点，则返回左右子节点偷/不偷的最大值

        return arr;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
//        this.left = null;
//        this.right = null;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}