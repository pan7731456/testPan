package Tree;

import lombok.Data;

/**
 * @Author pan
 * @Date 2020/4/17 14:06
 * @Description 二叉树
 * @Version 1.0
 **/
public class BinaryTree {
    //根节点
    private Node root;

    @Data
    public class Node {
        //编号
        private Integer no;
        //节点值
        private Integer value;
        //左节点
        private Node left;
        //右节点
        private Node right;
    }

    /**
     * 前序遍历，暴露的写法
     */
    public void preOrder(){

    }

    /**
     * 前序遍历
     */
    private void preOrder(Node node) {

    }

}
