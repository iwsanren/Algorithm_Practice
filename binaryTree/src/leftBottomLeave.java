import java.util.List;

public class leftBottomLeave {
    private int depth = -1;
    private int result = 0;
    public int findBottomLeftValue(TreeNode root) {
        result = root.val;
        bottomLeftTraversal(root,0);
        return result;
    }
    private void bottomLeftTraversal(TreeNode node, int depth){
        //叶子节点
        if(node.left == null && node.right == null){
            //当当前深度大于最大深度时， 更新深度，并更新叶子值
            if(depth > this.depth){
                this.depth = depth;
                this.result = node.val;
            }
        }
        //如何判断节点是最左节点？只要先遍历左节点即可。最大深度会由左叶子确定，后序再有相同深度的新的右叶子，也没办法进入if(depth > this.depth)循环了。从而无法覆盖result。
        if(node.left != null){
            depth++;
            bottomLeftTraversal(node.left,depth);
            depth--;
        }
        if(node.right != null){
            depth++;
            bottomLeftTraversal(node.right,depth);
            depth--;
        }
    }
}
class leftBottomLeaveTest {
    public static void main(String[] args) {
        TreeBuilder tb = new TreeBuilder();
        TreeNode root = tb.buildTree();

        leftBottomLeave example = new leftBottomLeave();
        int i  = example.findBottomLeftValue(root);
        System.out.println(i);
    }
}