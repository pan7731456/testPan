package Tree;

import lombok.Data;

/**
 * @Author pan
 * @Date 2020/4/17 14:06
 * @Description 二叉树
 * @Version 1.0
 **/
@Data
public class BinaryTree {
    //根节点
    private Node root;

    /**
     * 前序遍历，暴露的写法
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

}
