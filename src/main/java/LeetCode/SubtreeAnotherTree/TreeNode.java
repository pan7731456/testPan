package LeetCode.SubtreeAnotherTree;

import lombok.Data;

/**
 * @Author pan
 * @Date 2020/5/7 11:34
 * @Description
 * @Version 1.0
 **/
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    /**
     * 前序遍历
     */
    public void list(){
        System.out.println(val);
        if (this.left != null){
            this.left.list();
        }
        if (this.right != null){
            this.right.list();
        }
    }
}
