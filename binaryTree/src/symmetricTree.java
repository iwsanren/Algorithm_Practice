import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class symmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return compare(root.left,root.right);
    }
    public boolean compare(TreeNode left, TreeNode right){
        //左右都为空/一个为空/都不为空但是值不相等/都不为空且值相等
        if(left == null && right == null) return true;
        if(left == null && right != null) return false;
        if(left != null && right == null) return false;
        if(left.val != right.val) return false;

        boolean inside = compare(left.right,right.left);
        boolean outside = compare(left.left,right.right);
        return inside && outside;
    }
}
class symmetricTreeTest {
    public static void main(String[] args) {
        symmetricTree st = new symmetricTree();
        TreeBuilder tb = new TreeBuilder();
        TreeNode root = tb.buildTree();
        boolean isSymmetric = st.isSymmetric(root);
        System.out.println(isSymmetric);
    }
}