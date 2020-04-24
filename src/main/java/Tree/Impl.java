package Tree;

/**
 * @Author pan
 * @Date 2020/4/24 17:54
 * @Description 二叉树实现
 * @Version 1.0
 **/
public class Impl {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        //生成二叉树
        Node root = new Node(1, "根节点");
        binaryTree.setRoot(root);
        Node node2 = new Node(2, "根左");
        Node node3 = new Node(3, "根右");
        root.setLeft(node2);
        root.setRight(node3);
        Node node4 = new Node(4, "左左");
        Node node5 = new Node(5, "左右");
        node2.setLeft(node4);
        node2.setRight(node5);
        Node node6 = new Node(6, "右左");
        Node node7 = new Node(7, "右右");
        node3.setLeft(node6);
        node3.setRight(node7);
        Node node8 = new Node(8, "左左左");
        node4.setLeft(node8);

//        Node node9 = new Node(9, "左一");
//        Node node10 = new Node(10, "左一");
//        Node node11 = new Node(11, "左一");
//        Node node12 = new Node(12, "左一");


        //测试
        binaryTree.postOrder();
    }
}
