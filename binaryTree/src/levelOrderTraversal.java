import java.util.*;
//10道超绝层序遍历基础题：
//102.二叉树的层序遍历(opens new window)
//107.二叉树的层次遍历II(opens new window)
//199.二叉树的右视图(opens new window)
//637.二叉树的层平均值(opens new window)
//429.N叉树的层序遍历(opens new window)
//515.在每个树行中找最大值(opens new window)
//116.填充每个节点的下一个右侧节点指针(opens new window)
//117.填充每个节点的下一个右侧节点指针II(opens new window)
//104.二叉树的最大深度(opens new window)
//111.二叉树的最小深度
public class levelOrderTraversal {
    //102.二叉树的层序遍历(opens new window)
    public List<List<Integer>> levelOrder(TreeNode root) {
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
    //107.二叉树的层次遍历II(opens new window)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> nums = new LinkedList<>();
            while(size>0){
                TreeNode node = deque.peekFirst();
                nums.add(node.val);
                deque.pollFirst();
                if(node.left != null) deque.offerLast(node.left);
                if(node.right != null) deque.offerLast(node.right);
                size--;
            }
            result.add(nums);
        }
        Collections.reverse(result);
        return result;
    }
    //199.二叉树的右视图(opens new window)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            while (size > 0){
                TreeNode node = deque.peekFirst();
                if(size == 1){
                    result.add(node.val);
                }
                deque.pollFirst();
                if(node.left != null) deque.offerLast(node.left);
                if(node.right != null) deque.offerLast(node.right);
                size--;
            }
        }
        return result;
    }
    //637.二叉树的层平均值(opens new window)
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<>();
        if(root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()){
//            double size = deque.size();
//            double sum = 0;
//            int count = (int) size;
//            while(count > 0){
//                TreeNode node = deque.peekFirst();
//                sum += node.val;
//                deque.pollFirst();
//                if(node.left != null) deque.offerLast(node.left);
//                if(node.right != null) deque.offerLast(node.right);
//                count--;
//            }
//            result.add(sum/size);
//===================这段while循环内的代码可以简化一下，deque的size就是要循环的次数。这样优化以后效率大大提高===================
            int levelSize = deque.size();
            double sum = 0.0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.peekFirst();
                deque.pollFirst();
                sum += node.val;
                if(node.left != null) deque.offerLast(node.left);
                if(node.right != null) deque.offerLast(node.right);
            }
            result.add(sum/levelSize);
        }
        return result;
    }
    //429.N叉树的层序遍历(opens new window)
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;

        Deque<Node> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> nums = new LinkedList<>();
            while(size > 0){
                Node node = deque.peekFirst();
                nums.add(node.val);
                deque.pollFirst();
                List<Node> children = node.children;
                for(Node cn : children){
                    deque.offerLast(cn);
                }
                size--;
            }
            result.add(nums);
        }
        return result;
    }

    //515.在每个树行中找最大值(opens new window)
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            int max = deque.peek().val;
            while(size > 0){
                TreeNode node = deque.peekFirst();
                deque.pollFirst();
                max = Math.max(max,node.val);
                if(node.left != null) deque.offerLast(node.left);
                if(node.right != null) deque.offerLast(node.right);
                size--;
            }
            result.add(max);
        }
        return result;
    }

    //116.填充每个节点的下一个右侧节点指针(opens new window)
    public Node116 connect(Node116 root) {
        if(root == null) return root;
        Deque<Node116> deque = new LinkedList<>();
        deque.add(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            Node116 cur = deque.pollFirst();
            if (cur.left != null) deque.add(cur.left);
            if (cur.right != null) deque.add(cur.right);

            for (int i = 1; i < size; i++) {
                Node116 next = deque.pollFirst();
                if (next.left != null) deque.add(next.left);
                if (next.right != null) deque.add(next.right);

                cur.next = next;
                cur = next;
            }
        }
        return root;
    }

    //117.填充每个节点的下一个右侧节点指针II(opens new window)
    public Node116 connect117(Node116 root) {
        if(root == null) return root;
        Deque<Node116> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            Node116 cur = deque.pollFirst();
            if(cur.left != null) deque.offerLast(cur.left);
            if(cur.right != null) deque.offerLast(cur.right);

            for (int i = 1; i < size; i++) {
                Node116 next = deque.pollFirst();
                if(next.left != null) deque.offerLast(next.left);
                if(next.right != null) deque.offerLast(next.right);

                cur.next = next;
                cur = next;
            }
        }
        return root;
    }

    //104.二叉树的最大深度(opens new window)
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root == null) return depth;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
                while(size > 0){
                    TreeNode node = deque.pollFirst();//放在里面定义，确保每次size--都可以弹出一个node。
                    if(node.left != null) deque.offerLast(node.left);
                    if(node.right != null) deque.offerLast(node.right);
                    size--;
                }
            depth++;
        }
        return depth;
    }

    //111.二叉树的最小深度
    public int minDepth(TreeNode root) {
        int depth = 0;
        if(root == null) return depth;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null) deque.offerLast(node.left);
                if(node.right != null) deque.offerLast(node.right);
            }
        }
        return depth;
    }

}
class levelOrderTraversalTest {
    public static void main(String[] args) {
        levelOrderTraversal lt = new levelOrderTraversal();
        TreeBuilder tb = new TreeBuilder();
        TreeNode root = tb.buildTree();
        //List<List<Integer>> list = lt.levelOrderBottom(root);
        //List<Integer> list = lt.largestValues(root);
//        for(List<Integer> levels :list){
//            System.out.print("[");
//            for(int nums : levels){
//                System.out.print(nums+" ");
//            }
//            System.out.println("]");
//        }
//        for(int i : list){
//            System.out.print(i+" ");
//        }
        int i = lt.minDepth(root);
        System.out.println(i);
    }
}
//N叉树的层序遍历(opens new window)
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
//116.填充每个节点的下一个右侧节点指针(opens new window)
//117.填充每个节点的下一个右侧节点指针II(opens new window)
class Node116 {
    public int val;
    public Node116 left;
    public Node116 right;
    public Node116 next;

    public Node116() {}

    public Node116(int _val) {
        val = _val;
    }

    public Node116(int val, Node116 left, Node116 right, Node116 next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}