package LeetCode.SubtreeAnotherTree;

/**
 * @Author pan
 * @Date 2020/5/7 11:22
 * @Description
 * @Version 1.0
 **/
public class SubtreeAnotherTree {

    /**
     * 依次比较所有子集
     *
     * @param s 二叉树原型
     * @param t 对比子集二叉树
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null){
            //说明没有子集了,直接返回false
            return false;
        }
        //进行判断，同时再进行子集的判断
        return preCompare(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * 前序遍历比较每一个节点
     *
     * @param s
     * @param t
     * @return
     */
    public boolean preCompare(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        //由于子集的概念是所有子节点，因此这里的判断条件不包括局部相等，需要比较的是子集，因此只有两种都不是同时为null，都说明子集不同
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && preCompare(s.left, t.left) && preCompare(s.right, t.right);
    }

}
