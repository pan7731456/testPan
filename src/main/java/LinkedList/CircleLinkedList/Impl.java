package LinkedList.CircleLinkedList;

/**
 * @Author PYJ
 * @Description 使用环形链表，同时解决约瑟夫问题
 * @Date 2020/4/619:12
 * @Version 1.0
 **/
public class Impl {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        //假设有100个节点，解决约瑟夫问题，也就是一个环形数据中，取出数据
        for (int i = 0; i <100 ; i++) {
            circleLinkedList.add(i);
        }
        int count = 1;
        while (!circleLinkedList.isEmpty()){
            System.out.printf("第%d轮取出数据:[%d]\n", (count++), circleLinkedList.getJoseph(2));
        }
        circleLinkedList.list();
    }
}
