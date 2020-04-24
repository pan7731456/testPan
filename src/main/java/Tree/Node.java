package Tree;

import lombok.Data;

/**
 * @Author pan
 * @Date 2020/4/24 17:58
 * @Description
 * @Version 1.0
 **/
@Data
public class Node {
    //编号
    private Integer no;
    //节点值
    private String value;
    //左节点
    private Node left;
    //右节点
    private Node right;

    public Node(Integer no, String value) {
        this.no = no;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", value='" + value + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        //先左再中再右
        if (this.left != null) {
            this.left.preOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        //先左再右最后输出中
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
        System.out.println(this);
    }
}
