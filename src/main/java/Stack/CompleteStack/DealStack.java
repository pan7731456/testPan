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
    private StackLinked amountStack; //多位数处理栈

    public DealStack() {
        this.numStack = new StackLinked();
        this.charStack = new StackLinked();
        this.amountStack = new StackLinked();
    }

    /**
     * 根据字符串处理计算过程
     *
     * @param deal
     * @return
     */
    public int deal(String deal) {
        char[] charArray = deal.trim().toCharArray();
        /**
         * 上一个set进去的数据，做数据校验做，一般set顺序应该为 数字 符号 数字 符号
         * 假定开始是前一位是符号，那么第一次set进去的就一定要是数字了
         */
        int preType = 1;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == ' ') { //跳过空格
                //空格必须是在字符/数字之间才能存在的，否则视为报错字符，不能无脑忽视
                char pre = charArray[i - 1];
                char next = charArray[i + 1];
                if ((isNum(pre) && isNum(next))) { //不能都为数字，避免 66 66这种格式变成6666
                    throw new RuntimeException("空格前后都是数字，格式不满足");
                }
                continue;
            }
            if (isNum(c)) {
                //设置数字的时候不是直接push进去，直到判断后面那一位是字符了才push进去
//                System.out.println("设置到多位数栈中" + ((int) c - 48));
                amountStack.push((int) c - 48);

                if ((i + 1) == charArray.length) {
                    //说明最后一个数
                    int amountNum = amountNum();
//                    System.out.println("数字判断中取出的多位数:" + amountNum);
                    numStack.push(amountNum);
                }


//                numStack.push((int) c - 48); //转换为int需要-48
                preType = 0;
                continue;
            } else {
                //说明是符号
                if (preType != 0) {
                    throw new RuntimeException("错误的符号设置，格式不满足");
                }

                //多位数取到符号为止，符号之前的所有数字都取出，按照个十百的取出顺序获取对应的值
                if (!amountStack.isEmpty()) {
                    int amountNum = amountNum();
//                    System.out.println("取出的多位数:" + amountNum);
                    numStack.push(amountNum);
                }

                //符号需要做处理，如果上一个符号优先度大于现在的符号，说明需要先计算
                //需要判断优先度
//                    boolean b = priority((char) charStack.peek()) > priority(c);
//                    System.out.println("当前符号:" + c + "结果是:" + b);
//                    System.out.println("符号栈顶优先度:" + (char) charStack.peek() + "-" + priority((char) charStack.peek()) + " : " + c + "-" + priority(c));
                while (!charStack.isEmpty() && priority((char) charStack.peek()) > priority(c)) {
                    //需要优先计算
                    char pre = (char) charStack.pop();
                    int num1 = (int) numStack.pop();
                    int num2 = (int) numStack.pop();
                    int result = calculate(num1, num2, pre);
                    System.out.println("优先计算 " + num2 + " " + pre + " " + num1 + " = " + result);
                    numStack.push(result); //设置结果

//                    System.out.println();
                }
                preType = 1;
                charStack.push(c);
                continue;
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

    private int amountNum() {
        int value = 0;
        int seat = 1;
        int num = 0;
        while (!amountStack.isEmpty()) {
            num = (int) amountStack.pop();
            value += seat * num; //依次取出个、十、百位数
            seat *= 10;
        }
        return value;
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
