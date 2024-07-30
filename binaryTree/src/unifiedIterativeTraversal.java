import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class unifiedIterativeTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            //当栈不为空的时候，才要取node节点。
            TreeNode node = stack.peek();
            if(node != null){
                stack.pop();
                //入栈顺序：右左中
                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);
                stack.push(node);
                stack.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。
            }else{
                stack.pop();//弹出空节点
                node = stack.peek();
                result.add(node.val);
                stack.pop();
            }
        }
        return result;
    }
}
class unifiedIterativeTraversalTest {
    public static void main(String[] args) {
        unifiedIterativeTraversal it = new unifiedIterativeTraversal();
        TreeBuilder tb = new TreeBuilder();
        TreeNode root = tb.buildTree();
        List<Integer> list = it.preorderTraversal(root);
        for(int i:list){
            System.out.print(i+" ");
        }
    }
}
