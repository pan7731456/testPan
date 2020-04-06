package Stack.StackPrototype;

import lombok.Data;

/**
 * @Author PYJ
 * @Description 链表栈
 * @Date 2020/4/620:13
 * @Version 1.0
 **/
public class StackLinked<T> implements Stack<T> {
    private Node head; //头节点
    private int size; //栈中有效数据

    @Data
    class Node{
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    @Override
    public void push(T value) {
        Node node = new Node(value);
        Node head = this.head; //取当前头节点
        this.head = node;
        node.next = head;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new RuntimeException("栈为空，无法取出数据");
        }
        Node head = this.head;
        this.head = head.next;
        size--;
        return head.value;
    }

    @Override
    public T peek() {
        return this.head.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void list() {
        if (isEmpty()){
            System.out.println("空栈，没有数据");
            return;
        }
        Node head = this.head;

        for (int index = 1; head != null ; index++, head= head.next) {
            System.out.println("第"+ index + "个数据为"+ head.value);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public boolean isFull() {
        return false; //链表形式，永远不会满，永远是false
    }
}
