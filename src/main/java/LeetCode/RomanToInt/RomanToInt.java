package LeetCode.RomanToInt;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author pan
 * @Date 2020/5/27 16:17
 * @Description 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * @Version 1.0
 **/
public class RomanToInt {

    /**
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     *
     * @param s 罗马数
     * @return
     */
    public int romanToInt(String s) {
        /**
         * 特点便是 I X C 为特殊的3个数字，这三个数字很常用，可以出现多个，代表累加位
         * V L D 代表中间位 只能出现一次
         */
        int roman = 0;
        char cur;
        char next;
        Map<Character, Integer> values = new HashMap<>();
        //初始值
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);
            switch (cur) {
                case 'I':
                    roman += 1;
                    break;
                case 'V':
                    //需要判断左边是否为I
                    roman += leftRoman(s, i, 'I', 'V', values);
                    break;
                case 'X':
                    roman += leftRoman(s, i, 'I', 'X', values);
                    break;
                case 'L':
                    roman += leftRoman(s, i, 'X', 'L', values);
                    break;
                case 'C':
                    roman += leftRoman(s, i, 'X', 'C', values);
                    break;
                case 'D':
                    roman += leftRoman(s, i, 'C', 'D', values);
                    break;
                case 'M':
                    roman += leftRoman(s, i, 'C', 'M', values);
                    break;
            }
        }
        return roman;
    }

    private int leftRoman(String s, int i, char left, char cur, Map<Character, Integer> values) {
        //如果下一位是某些数，则进行返还
        if (i - 1 >= 0 && s.charAt(i - 1) == left) {
            //由于已经加了一次，因此减两次，本身也要减1次 + 加的1次
            return (values.get(cur) - 2 * values.get(left));
        } else {
            return values.get(cur);
        }
    }
}
