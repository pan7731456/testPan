package LeetCode.SubtreeAnotherTree;

/**
 * @Author pan
 * @Date 2020/5/7 14:24
 * @Description
 * @Version 1.0
 **/
public class Solution {

    //判断是否包含相同的树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }

        return (isSameTree(s, t)) || (isSubtree(s.left, t)) || (isSubtree(s.right, t));
    }

    //判读树是否为相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
    }
}
