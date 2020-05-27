package LeetCode.RomanToInt;

import LeetCode.MaxProduct.LeetCode;

/**
 * @Author pan
 * @Date 2020/5/27 17:06
 * @Description
 * @Version 1.0
 **/
public class PeopelSolution {

    /**
     * 按照当前位处理上一个数的思路
     * 我的思路是处理当前数，前面那个数已经加了就扣回来
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
