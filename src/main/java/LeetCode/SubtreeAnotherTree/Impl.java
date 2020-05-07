package LeetCode.SubtreeAnotherTree;

/**
 * @Author pan
 * @Date 2020/5/7 11:24
 * @Description
 * @Version 1.0
 **/
public class Impl {

    public static void main(String[] args) {
        SubtreeAnotherTree subtreeAnotherTree = new SubtreeAnotherTree();
//        TreeNode s_root = new TreeNode(3);
//        TreeNode s_1 = new TreeNode(4);
//        TreeNode s_1_1 = new TreeNode(1);
//        TreeNode s_1_2 = new TreeNode(2);
//        TreeNode s_2 = new TreeNode(5);
//        s_root.setLeft(s_1);
//        s_root.setRight(s_2);
//        s_1.setLeft(s_1_1);
//        s_1.setRight(s_1_2);
//
//        TreeNode t_root = new TreeNode(4);
//        TreeNode t_1 = new TreeNode(1);
//        TreeNode t_2 = new TreeNode(2);
//        t_root.setLeft(t_1);
//        t_root.setRight(t_2);

        TreeNode s_root = new TreeNode(1);
        TreeNode s_1 = new TreeNode(2);
        TreeNode s_1_1 = new TreeNode(3);
        s_root.setLeft(s_1);
        s_1.setLeft(s_1_1);

        TreeNode t_root = new TreeNode(1);
        TreeNode t_1 = new TreeNode(2);
        t_root.setLeft(t_1);

        System.out.println(subtreeAnotherTree.isSubtree(s_root, t_root));
    }
}
