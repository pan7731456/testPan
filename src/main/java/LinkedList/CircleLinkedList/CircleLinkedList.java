package LinkedList.CircleLinkedList;

/**
 * @Author PYJ
 * @Description
 * @Date 2020/4/618:34
 * @Version 1.0
 **/
public class CircleLinkedList {
    private Node first; //第一个节点

    private int size; //链表个数

    class Node{
        private int value; //存储的节点值
        private Node next; //下一个节点

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 分析，环形链表，是指形成环状的链表，特点是最后一个节点，指向第一个节点
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * 添加一个节点
     *
     * @param value
     */
    public void add(int value){
        Node node = new Node(value);
        //直接在最后一个节点进行操作
        Node first = this.first;
        if (first == null){ //说明是空链表
            this.first = node;
            node.next = node; //形成环状
            size++;
            return;
        }
        //找到最后一个节点加上去
        while (first.next != this.first){
            first = first.next;
        }
        //这时候first的next节点指向就是first，说明就是在尾节点了
        first.next = node;
        node.next = this.first;
        size++;
    }

    /**
     * 拿出next多少次后的节点，拿出后下一个节点设置为起始位置，也就是头节点
     * 解决约瑟夫问题，n个小孩围成一个圈，然后每次数x次，拿出对应的小孩，直至数组中没有数据
     *
     * @param time
     * @return
     */
    public int getJoseph(int time){
        Node first = this.first;
        if (first == null){
            System.out.println("环形链表为空，无法取出数据");
        }
        //得到要拿出节点的上一个位置
        for (int i = 1; i < time; i++) { //这里设置初始为1,这样就保证拿到了前一个节点
            first = first.next;
        }
        Node node = first.next;
        if (first == node){ //说明仅有一个节点了
            this.first = null; //设置为空节点
            return first.value;
        }
        //说明有多个节点
        Node next = node.next;
        this.first = next; //从下一个节点开始，置为头部
        first.next = next; //这时node就没有指向，形不成引用，会被垃圾回收
        return node.value;
    }

    /**
     * 遍历输出环形链表的数据
     */
    public void list(){
        Node first = this.first;
        if (first == null){
            System.out.println("环形链表没有数据！");
            return;
        }
        int index = 1;
        while (true){
            System.out.println("第"+ index + "个数据为" + first.value);
            first = first.next;
            index++;
            if (first == this.first){//说明已经遍历完了，遍历了一圈，重新指向了头节点
                break;
            }
        }
    }
}
