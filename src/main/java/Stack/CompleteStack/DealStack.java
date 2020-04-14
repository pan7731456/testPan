package Stack.CompleteStack;

import Stack.StackPrototype.StackLinked;

/**
 * @Author pan
 * @Date 2020/4/13 11:35
 * @Description 重写模拟计算机的计算栈
 * @Version 1.0
 **/
public class DealStack {

    private StackLinked numStack; //数字栈
    private StackLinked charStack; //符号栈

    public DealStack() {
        this.numStack = new StackLinked();
        this.charStack = new StackLinked();
    }

    /**
     * 根据字符串处理计算过程
     *
     * @param deal
     * @return
     */
    public int deal(String deal) {
        char[] charArray = deal.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == ' ') { //跳过空格
                continue;
            }
            if (isNum(c)) {
                numStack.push((int) c - 48); //转换为int需要-48
                continue;
            } else {
                //说明是符号

                //符号需要做处理，如果上一个符号优先度大于现在的符号，说明需要先计算
                if (!charStack.isEmpty()) {
                    //需要判断优先度
                    if (priority((char) charStack.peek()) > priority(c)) {
                        //需要优先计算
                        char pre = (char) charStack.pop();
                        int num1 = (int) numStack.pop();
                        int num2 = (int) numStack.pop();
                        int result = calculate(num1, num2, pre);
                        System.out.println("优先计算 " + num2 + " " + pre + " " + num1 + " = " + result);
                        numStack.push(result); //设置结果
                    }
                }
                charStack.push(c);
            }
        }

        while (!charStack.isEmpty()) {
            char pre = (char) charStack.pop();
            int num1 = (int) numStack.pop();
            int num2 = (int) numStack.pop();
            int result = calculate(num1, num2, pre);
            System.out.println("剩余计算 " + num2 + " " + pre + " " + num1 + " = " + result);
            numStack.push(result); //设置结果
        }


        return (int) numStack.pop();
    }

    private int calculate(int num1, int num2, char pre) {
        int result;
        switch (pre) {
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                throw new RuntimeException("未定义的符号!");
        }
        return result;
    }

    private int priority(char c) {
        switch (c) {
            case '+':
                return 0;
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new RuntimeException("未知符号");
        }
    }


    /**
     * 判断该符号是否是数字
     *
     * @param c
     * @return
     */
    private boolean isNum(char c) {
        if (c >= 48 && c <= 57) {
            return true;
        }
        return false;
    }
}
