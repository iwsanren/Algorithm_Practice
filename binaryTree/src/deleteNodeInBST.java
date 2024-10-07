public class deleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key){
            if(root.left == null && root.right == null) return null;
            if(root.left != null && root.right == null) return root.left;
            if(root.left == null && root.right != null) return root.right;
            if(root.left != null && root.right != null){
                TreeNode cur = root.right;
                while(cur.left != null){
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        if(key > root.val){
            root.right = deleteNode(root.right,key);
        }else if(key < root.val){
            root.left = deleteNode(root.left,key);
        }
        return root;
    }
}
class deleteNodeInBSTTest {

}