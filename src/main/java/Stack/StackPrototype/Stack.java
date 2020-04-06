package Stack.StackPrototype;

public interface Stack<T> {

    /**
     * 栈中添加数据
     */
    void push(T value);

    /**
     * 栈中获取数据
     *
     * @return
     */
    T pop();

    /**
     * 栈顶数据
     *
     * @return
     */
    T peek();

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
