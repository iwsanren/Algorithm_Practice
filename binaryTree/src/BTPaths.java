import java.util.LinkedList;
import java.util.List;

public class BTPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if(root == null) return result;

        List<Integer> path = new LinkedList<>();//用于存储每条路径
        traversal(root,path,result);
        return result;
    }
    private void traversal(TreeNode node, List<Integer> path, List<String> res){
        path.add(node.val);
        StringBuilder sb = new StringBuilder();
        if(node.left == null && node.right == null){
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i) + "->");
            }
            sb.append(path.get(path.size()-1));
            res.add(sb.toString());
            return;
        }
        if(node.left != null){
            traversal(node.left,path,res);
            path.remove(path.size()-1);//返回上一个节点
        }
        if(node.right != null){
            traversal(node.right,path,res);
            path.remove(path.size()-1);
        }

    }
}
class BTPathsTest {
    public static void main(String[] args) {
        TreeBuilder tb = new TreeBuilder();
        TreeNode root = tb.buildTree();

        BTPaths btp = new BTPaths();
        List<String> res = btp.binaryTreePaths(root);
        for(String s:res){
            System.out.println(s);
        }
    }
}
