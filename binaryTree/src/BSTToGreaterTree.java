public class BSTToGreaterTree {
    int pre;
    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }
    void traversal(TreeNode cur){
        if(cur == null) return;
        traversal(cur.right);
        cur.val  += pre;
        pre = cur.val;
        traversal(cur.left);
    }
}
class BSTToGreaterTreeTest {
}