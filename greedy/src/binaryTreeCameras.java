public class binaryTreeCameras {
    int result = 0;
    public int minCameraCover(TreeNode root) {
        //当头节点没有被覆盖，需要将一个头布置在头结点上。
        if(traversal(root) == 0) result++;
        return result;
    }

    public int traversal(TreeNode root){
        //根节点不布置摄像头，直接返回有覆盖
        if(root == null){
            return 2;
        }

        int left = traversal(root.left);
        int right = traversal(root.right);
        // 如果左右节点都覆盖了的话, 那么本节点的状态就应该是无覆盖,没有摄像头
        if(left == 2 && right == 2){
            return 0;
        //左右节点存在无覆盖状态,那 根节点此时应该放一个摄像头
        }else if(left==0||right==0){
            result++;
            return 1;
        }else{
            //左右节点至少存在一个摄像头
            return 2;
        }
    }
}
