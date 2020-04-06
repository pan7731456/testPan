package Stack.CompleteStack;

import Stack.StackPrototype.StackLinked;

/**
 * @Author PYJ
 * @Description
 * @Date 2020/4/620:34
 * @Version 1.0
 **/
public class CompleteStack {
    /**
     * 思路分析：分别有数字栈，符号栈，如遇符号优先度较高，则提取出之前pop进去的数，先完成计算再进行操作，直至排完所有数据
     * 最后取出栈中所有数据计算ch
     * 由于只有两种优先度，因此可以用这种方法完成,分别为2和1
     */

    public int complete(String input){
        StackLinked numStack = new StackLinked(); //数字栈
        StackLinked charStack = new StackLinked(); //符号栈

        char[] chars = input.toCharArray();

        //处理乘法和除法
        for (char c : chars ) {
            if (c == ' '){
                continue;
            }
            if (isNum(c)){
                numStack.push((int) c - 48);
            } else {
                //插入前需要比较优先度
                compare(numStack, charStack, c);
                charStack.push(c);
            }
        }
        //计算加法和减法
        while (charStack.size() != 0){
            deal(numStack, charStack);
        }
        return (int) numStack.pop();
    }

    private void compare(StackLinked numStack, StackLinked charStack, char c) {
        if (charStack.size() != 0){ //有多个值才能比较优先度
            if (priority(c) <= priority((Character) charStack.peek())){
                deal(numStack, charStack);
            }
        }
    }

    private void deal(StackLinked numStack, StackLinked charStack) {
        Character character = (Character) charStack.pop(); //取出符号
        Integer num1 = (Integer) numStack.pop();
        Integer num2 = (Integer) numStack.pop();
        int result = calculate(num1, num2, character);
        numStack.push(result);
    }

    /**
     * 是否是数字字符
     * @param c
     * @return
     */
    private boolean isNum(char c){
        if (c >= 48 && c <= 57){
            return true;
        }
        return false;
    }

    /**
     * 获取字符优先度
     *
     * @return
     */
    private int priority(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new RuntimeException("未知符号");
        }
    }

    private int calculate(int num1, int num2, char c){
        int result = 0;
        switch (c){
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result =  num2 * num1;
                break;
            case '/':
                result =  num2 / num1;
                break;
            default:
                throw new RuntimeException("未知符号");
        }
        System.out.println("进行了运算:" + num2 + " "+ c +" " + num1 + "的结果是"+ result);
        return result;
    }

}
