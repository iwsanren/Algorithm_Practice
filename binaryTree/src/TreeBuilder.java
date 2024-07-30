public class TreeBuilder {
    public static TreeNode buildTree() {
        // 根节点
        TreeNode root = new TreeNode(1);

        // 第二层
        TreeNode level2Left = new TreeNode(2);
        TreeNode level2Right = new TreeNode(3);
        root.left = level2Left;
        root.right = level2Right;

        // 第三层
        TreeNode level3Left1 = new TreeNode(4);
        TreeNode level3Right1 = new TreeNode(5);
        TreeNode level3Left2 = new TreeNode(6);
        TreeNode level3Right2 = new TreeNode(7);

        level2Left.left = level3Left1;
        level2Left.right = level3Right1;
        level2Right.left = level3Left2;
        level2Right.right = level3Right2;

        // 第四层
        TreeNode level4Left1 = new TreeNode(8);
        TreeNode level4Right1 = new TreeNode(9);
        TreeNode level4Left2 = new TreeNode(10);
        TreeNode level4Right2 = new TreeNode(11);
        TreeNode level4Left3 = new TreeNode(12);
        TreeNode level4Right3 = new TreeNode(13);
        TreeNode level4Left4 = new TreeNode(14);
        TreeNode level4Right4 = new TreeNode(15);

        level3Left1.left = level4Left1;
        level3Left1.right = level4Right1;

        level3Right1.left = level4Left2;
        level3Right1.right = level4Right2;

        level3Left2.left = level4Left3;
        level3Left2.right = level4Right3;

        level3Right2.left = level4Left4;
        level3Right2.right = level4Right4;

        return root;
    }
}
