import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class invertBT {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        invertTree(root.left);
        invertTree(root.right);
        swapChilderen(root);
        return root;
    }
    public void swapChilderen(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
class invertBTTest {
    public static void main(String[] args) {
        invertBT ibt = new invertBT();
        TreeBuilder tb = new TreeBuilder();
        TreeNode root = tb.buildTree();
        root = ibt.invertTree(root);

        //I use lever order tarversal here, because it's more easy to imagine the tree's picture.
        invertBTTest ibtt = new invertBTTest();
        List<List<Integer>> list = ibtt.levelOrderTraversal(root);
        for(List<Integer> levels :list){
            System.out.print("[");
            for(int nums : levels){
                System.out.print(nums+" ");
            }
            System.out.println("]");
        }
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode node){
        List<List<Integer>> result = new LinkedList<>();
        if(node == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(node);

        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> nums = new LinkedList<>();
            while(size > 0){
                TreeNode tmp = deque.pollFirst();
                nums.add(tmp.val);
                if(tmp.left != null) deque.offerLast(tmp.left);
                if(tmp.right != null) deque.offerLast(tmp.right);
                size--;
            }
            result.add(nums);
        }
        return result;
    }
}
