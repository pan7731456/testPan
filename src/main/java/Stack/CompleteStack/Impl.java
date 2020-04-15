package Stack.CompleteStack;

import Stack.StackPrototype.StackLinked;

/**
 * @Author PYJ
 * @Description 计算机思维实现计算，用栈实现
 * @Date 2020/4/6 20:28
 * @Version 1.0
 **/
public class Impl {
    /**
     * 中缀计算机思维算法
     * 通过中缀表达式，来实现计算机思维的转化，实现计算功能
     */
    public static void main(String[] args) {
//        String input = "3 * 4 + 5 * 6 - 10 / 5 + (4 + 3) * 6";
        String input = "3 * 4 + 5 * 6 - 4 / 2 + 7 * 6"; // 12 + 30 - 2 + 42 = 82
//        String input = "3 + 2 * 6 - 2 + 8 + 9 - 8 * 3";
//        String input = "66 - 66 + 77";
        //对这一串数组实现计算机思维算法
        DealStack dealStack = new DealStack();
        int complete = dealStack.deal(input);
        System.out.println(complete);


    }
}
