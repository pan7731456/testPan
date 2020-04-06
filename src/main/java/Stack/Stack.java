package Stack;

public interface Stack {

    /**
     * 栈中添加数据
     */
    void push(int value);

    /**
     * 栈中获取数据
     *
     * @return
     */
    int pop();

    /**
     * 栈顶数据
     *
     * @return
     */
    int head();

    /**
     * 栈中数据大小
     *
     * @return
     */
    int size();

    /**
     * 遍历输出栈中数据
     */
    void list();

    /**
     * 栈是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 栈是否已满
     *
     * @return
     */
    boolean isFull();
}
