import java.util.LinkedList;
import java.util.List;

public class modeInBST {
    TreeNode pre = null;
    int count = 0;
    int maxCount = 0;
    List<Integer> result = new LinkedList<>();
    public int[] findMode(TreeNode root) {
        traversal(root);
        int size = result.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
    private void traversal(TreeNode root){
        if(root == null) return;
        //左
        traversal(root.left);
        //中
        if(pre == null || pre.val != root.val){
            count = 1;
        }else{
            count++;
        }
        pre = root;
        //当这个数字出现频率比最大频率高时，清空list，增加新元素。
        if(count == maxCount){
            result.add(root.val);
        }else if(count > maxCount){
            maxCount = count;
            result.clear();
            result.add(root.val);
        }
        //右
        traversal(root.right);
    }

}
