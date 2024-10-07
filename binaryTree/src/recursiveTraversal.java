import java.util.ArrayList;
import java.util.List;

public class recursiveTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root,result);
        return result;
    }
    void preorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }
//======================================================================
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }
    void inorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
//=============================================================================
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root,result);
        return result;
    }
    void postorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }
}
class recursiveTraversalTest{
    public static void main(String[] args) {
        recursiveTraversal rt = new recursiveTraversal();
        TreeBuilder tb = new TreeBuilder();
        TreeNode root = tb.buildTree();
        List<Integer> list1 = rt.preorderTraversal(root);
        List<Integer> list2 = rt.inorderTraversal(root);
        List<Integer> list3 = rt.postorderTraversal(root);
        for(int i:list1){            System.out.print(i+",");        }
        System.out.println();
        for(int i:list2){            System.out.print(i+",");        }
        System.out.println();
        for(int i:list3){            System.out.print(i+",");        }
    }
}
