package Stack.StackPrototype;

import java.util.Stack;

/**
 * @Author PYJ
 * @Description
 * @Date 2020/4/620:08
 * @Version 1.0
 **/
public class Impl {
    public static void main(String[] args) {
        //StackArray stackArray = new StackArray(10);
        StackLinked stackArray = new StackLinked();
        for (int i = 0; i < 10; i++) {
            stackArray.push('+');
        }
        stackArray.list();
        try {
            stackArray.push(100);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("栈中取数据:"+stackArray.pop());
        System.out.println("栈中取数据:"+stackArray.pop());
        System.out.println("栈顶数据为:" + stackArray.peek());
        System.out.println("栈中取数据:"+stackArray.pop());
        stackArray.list();

    }
}
