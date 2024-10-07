import java.util.*;

public class constructBT {
    //建立一个map用来存储inorder。为什么只要inorder呢？因为inorder需要通过数值来查找下标，而postorder不需要。
    Map<Integer,Integer> mapInorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        mapInorder = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mapInorder.put(inorder[i],i);
        }
        return getNodes(inorder,0,inorder.length,postorder,0,postorder.length);
    }
    private TreeNode getNodes(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        //如果为空，直接返回空
        if(inStart >= inEnd || postStart >= postEnd) return null;

        int val = postorder[postEnd-1];
        TreeNode node = new TreeNode(val);//构造节点
        int midPosition = mapInorder.get(val);
        int lenOfLeft = midPosition-inStart;//左子树的节点个数
        //用中序遍历得到的左子树的节点个数去定位后序遍历左子树的节点
        node.left = getNodes(inorder, inStart, midPosition, postorder, postStart, postStart + lenOfLeft);
        //中序遍历：左中右，后序遍历：左右中。
        //中序遍历数组从midPosition+1开始，因为midPosition的node已经被记录了。
        node.right = getNodes(inorder, midPosition + 1, inEnd, postorder, postStart + lenOfLeft, postEnd-1);

        return node;
    }
}
class constructBTTest {
    public static void main(String[] args) {
        int[] inorder = {8,4,9,2,10,5,11,1,12,6,13,3,14,7,15};
        int[] postorder = {8,9,4,10,11,5,2,12,13,6,14,15,7,3,1};
        constructBT cbt  = new constructBT();
        TreeNode node = cbt.buildTree(inorder,postorder);

        List<List<Integer>> list = levelOrder(node);
        for(List<Integer> levels :list){
            System.out.print("[");
            for(int nums : levels){
                System.out.print(nums+" ");
            }
            System.out.println("]");
        }
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();//保存结果
        if(root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> levelNums = new LinkedList<>();//保存每一层的结果
            while(size > 0){
                TreeNode node = deque.peekFirst();
                levelNums.add(node.val);
                deque.pollFirst();//要记得把添加过的元素弹出！
                if(node.left != null) deque.offerLast(node.left);
                if(node.right != null) deque.offerLast(node.right);
                size--;
            }
            result.add(levelNums);
        }
        return result;
    }
}