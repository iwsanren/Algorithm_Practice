import java.util.*;

public class iterativeTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        //剪枝
        if(root == null) return result;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            //中
            if(node != null){
                result.add(node.val);
            }else{
                continue;
            }
            //右
            if(node.right != null)                st.push(node.right);
            //左
            if(node.left != null)                st.push(node.left);
        }
        return result;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack  = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
class iterativeTraversalTest {
    public static void main(String[] args) {
        iterativeTraversal it = new iterativeTraversal();
        TreeBuilder tb = new TreeBuilder();
        TreeNode root = tb.buildTree();
        List<Integer> list = it.preorderTraversal(root);
        for(int i:list){
            System.out.print(i+" ");
        }

    }
}