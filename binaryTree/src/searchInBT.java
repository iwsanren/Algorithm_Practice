import java.util.Stack;

public class searchInBT {
    public TreeNode searchBST(TreeNode root, int val) {
        //recursive

//        if(root == null || root.val == val) return root;
//        TreeNode result = new TreeNode();
//        if(val < root.val) result = searchBST(root.left,val);
//        if(val > root.val) result = searchBST(root.right,val);
//        return result;

        //iterative
        if(root == null || root.val == val) return root;
        while(root != null){
            if(val < root.val){
                root = root.left;
            }else if(val > root.val){
                root = root.right;
            }else{
                return root;
            }
        }
        return null;
    }
}
class searchInBTTest {

}