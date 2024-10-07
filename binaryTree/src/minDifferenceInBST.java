public class minDifferenceInBST {
    //双指针
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }
    public void traversal(TreeNode cur){
        if(cur == null) return;
        //左
        traversal(cur.left);
        //中
        if(pre != null){
            result = Math.min(result,cur.val - pre.val);//取最小值
        }
        pre = cur;
        //右
        traversal(cur.right);
    }

}
class minDifferenceInBSTTest {
    public static void main(String[] args) {


    }
}