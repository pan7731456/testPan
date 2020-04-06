package CircleQueue;

import lombok.Data;

import java.util.Random;
import java.util.Scanner;

/**
 * 环形队列实现
 */
@Data
public class CircleQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        CircleQueue circleQueue = new CircleQueue(4);
        while (true){
            System.out.println("a-添加数据;g-取出数据;h-头部数据;l-遍历队列;s-队列有效数据个数;e-退出");
            try{
                switch(scanner.nextLine()) {
                    case "a":
                        circleQueue.addQueue(value++);
                        break;
                    case "g":
                        circleQueue.getQueue();
                        break;
                    case "h":
                        System.out.println("队列头部数据为:" + circleQueue.getHead());
                        break;
                    case "l":
                        circleQueue.list();
                        break;
                    case "s":
                        System.out.print("队列个数为:" + circleQueue.size());
                        break;
                    case "e":
                        return;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }


    private int[] values; //存放存储结果
    private int head; //头部位置
    private int tail; //尾部位置

    public CircleQueue(int size) {
        values = new int[size];
    }

    /**
     * 获取环形队列所能实现的最大存储数据量，有一个是预留位，预留处理数组已满的操作，因此实际-1
     *
     * @return
     */
    public int maxSize(){
        return values.length;
    }

    /**
     * 获取环形队列中的数据量
     *
     * @return
     */
    public int size(){
        return (tail + maxSize() - head) % maxSize();
    }

    /**
     * 数组是否已经满了
     *
     * @return
     */
    public boolean isFull(){
        return (tail + 1)% maxSize() == head;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty(){
        return (head == tail);
    }

    /**
     * 往环形队列中加数据
     *
     * @param value
     */
    public void addQueue(int value){
        if (isFull()){
            throw new RuntimeException("队列已满,无法添加数据");
        }
        values[tail] = value;
        tail = (tail + 1)% maxSize();
    }

    /**
     * 从队列中取数据
     *
     * @return
     */
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,无法取到数据");
        }
        int value = values[head];
        head = (head + 1) % maxSize();
        return value;
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,无法取到数据");
        }
        return values[head];
    }

    /**
     * 遍历输出队列
     */
    public void list(){
        if (isEmpty()){
            System.out.println("空队列");
            return;
        }
        for (int i = head, j = 0; j < size(); i = (i + 1)% maxSize(), j++) {
            System.out.println(values[i]);
        }
    }

}
