package Queue.CircleQueue;

import lombok.Data;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author PYJ
 * @Description 再次重写环形队列
 * @Date 2020/4/616:46
 * @Version 1.0
 **/
public class CircleQueue_Again {

    /**
     * 队列结构分析：先进先出
     * 环形队列，那么就会合理利用有效空间
     * 但是空和满的判断似乎重合了，因此需要有约定，约定一个空间不写入，当其中除约定空间外都填满的情况下，说明数组满了
     */

    /**
     * 内部类，用来定义环形数组的实现
     */
    @Data
    static
    class CircleQueue{
        private int[] values; //存储的数据
        private int head; //对应队列头部
        private int tail; //对应队列尾部

        /**
         * 定义构造器，maxSize定义数组能存多少数据
         * @param maxSize
         */
        public CircleQueue(int maxSize){
            values = new int[maxSize + 1]; //+1是因为有个约定,必定会有一个空格,因此为了满足最大存储数量,需要+1
        }

        /**
         * 判断队列是否为空
         * 约定两个指针位置重合就是空
         *
         * @return
         */
        public boolean isEmpty(){
            return head == tail;
        }

        /**
         * 判断队列是否满了
         * 为了防止和空冲突，因此空了一个位置,表示满
         * 同时有环形的概念，tail可能在head的下面，形成环形，重复利用空间
         * 因此需要进行取余操作
         *
         * @return
         */
        public boolean isFull(){
            return (tail + 1) % values.length == head;
        }

        /**
         * 在队列中添加数据
         *
         * @param value
         */
        public void addQueue(int value){
            /**
             * 分析：队列都是尾部插入的，插入前需要族判断
             */
            if (isFull()){
                throw new RuntimeException("队列已满，无法插入数据");
            }
            values[tail] = value; //赋值
            System.out.println("添加数据成功，其值为：" + value);
            tail = (tail + 1) % values.length; //尾部后移一位，为保证环形，需要取余
        }

        /**
         * 从队列中取出数据
         * 按照队列规则，从头部取出一个数据
         *
         * @return
         */
        public int getQueue(){
            if (isEmpty()){
                throw  new RuntimeException("队列为空，无法取出数据");
            }
            int value = values[head];
            head = (head + 1 + values.length)% values.length;
            return value;
        }

        /**
         * 查看队列头部的数据，不取出
         *
         * @return
         */
        public int headQueue(){
            if (isEmpty()){
                throw new RuntimeException("队列为空，无法查看头部数据");
            }
            return values[head];
        }

        public int size(){
            return (tail + values.length - head) % values.length;
        }

        public void list(){
            if (isEmpty()){
                System.out.println("队列中没有数据");
                return;
            }
            for (int i = 0; i <  size(); i++) {
                System.out.printf("队列第%d个数据为%d\n", i , values[(head + i) % values.length]);
            }
        }
    }

    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(10);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("请选择你的操作，来进行环形队列的模拟");
        System.out.println("a -- 添加数据到队列");
        System.out.println("g -- 取出数据从队列");
        System.out.println("h -- 查看队列的头部数据");
        System.out.println("s -- 查看队列的有效数据大小");
        System.out.println("l -- 查看队列的所有数据，从头部开始遍历");
        System.out.println("e -- 退出查看数据");
        while (true){
            try {
                switch (scanner.next()){
                    case "a":
                        //创建一个随机数添加到队列
                        circleQueue.addQueue(random.nextInt() % 10);
                        break;
                    case "g":
                        System.out.printf("取出队列数据:%d\n", circleQueue.getQueue());
                        break;
                    case "h":
                        System.out.printf("其队列头部数据:%d\n", circleQueue.headQueue());
                        break;
                    case "s":
                        System.out.printf("其队列大小:%d\n", circleQueue.size());
                        break;
                    case "l":
                        circleQueue.list();
                        break;
                    case "e":
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
