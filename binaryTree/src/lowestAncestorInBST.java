public class lowestAncestorInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //iterative
//        while(root != null){
//            //如果当前节点的值同时大于p和q的值，那么就向左遍历，去寻找共同祖先。
//            if(root.val > p.val && root.val > q.val){
//                root = root.left;
//            //如果当前节点的值同时小于p和q的值，那么就向右遍历，去寻找共同祖先。
//            }else if(root.val < p.val && root.val < q.val){
//                root = root.right;
//            //当前节点的值在p和q之间，直接return
//            }else{
//                return root;
//            }
//        }
//        return root;
//=================================================================================
// recursive-complete
        if(root.val > p.val && root.val > q.val){
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            if(left != null) return left;
        }else if(root.val < p.val && root.val < q.val){
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            if(right != null) return right;
        }else{
            return root;
        }
        return root;
//=================================================================================
// recursive-simplify
        //class Solution {
        //    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        //        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        //        return root;
        //    }
        //}

    }
}
