package Stack.StackPrototype;

/**
 * @Author PYJ
 * @Description 用数组实现栈
 * @Date 2020/4/619:54
 * @Version 1.0
 **/

import java.lang.reflect.Array;

/**
 * 分析：数组栈局限在于不符合栈的可扩展性，实际中应该是需要扩容操作，一般用链表的形式更好体现
 */
public class StackArray<T> implements Stack<T>{
    private int top; //栈顶指标
    private T[] values; //存储数据

    /**
     * 构造器，初始化数组栈
     *
     * @param maxSize 数组栈大小
     */
    public StackArray(int maxSize) {
        this.values = (T[]) Array.newInstance(StackArray.class, maxSize);
        this.top = -1;
    }

    @Override
    public void push(T value) {
        if (isFull()){
            throw new RuntimeException("栈已满，无法添加数据");
        }
        values[++top] = value; //插入数据，同时top指向头部
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new RuntimeException("栈为空，无法取出数据");
        }
        return values[top--];
    }

    @Override
    public T peek() {
        return values[top];
    }

    @Override
    public int size() {
        return top; //指针指向的是当前已存储的位置，就相当于是有效数据大小
    }

    @Override
    public void list() {
        for (int i = size(), index = 1; i >= 0; i-- ,index++) {
            System.out.printf("第%d个数据为%d\n", index, values[i]);
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == (values.length - 1);
    }
}
