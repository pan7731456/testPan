package LeetCode.Reverse;

/**
 * @Author pan
 * @Date 2020/5/27 15:25
 * @Description
 * @Version 1.0
 **/
public class Reverse {
    public int reverse(int x) {
        if (Integer.MIN_VALUE < x && x < Integer.MAX_VALUE) {
            //转换为字符组,然后反转
            String value = String.valueOf(x);
            //取符号位
            char charAt = value.charAt(0);
            StringBuffer stringBuffer = new StringBuffer(value);
            try {
                if (charAt == '+' || charAt == '-') {
                    stringBuffer.replace(0, 1, "");
                    stringBuffer.reverse();
                    String last = charAt + String.valueOf(stringBuffer);
                    return Integer.valueOf(last);
                } else {
                    stringBuffer.reverse();
                    String last = String.valueOf(stringBuffer);
                    return Integer.valueOf(last);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }
}
