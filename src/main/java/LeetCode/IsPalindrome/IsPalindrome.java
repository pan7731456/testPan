package LeetCode.IsPalindrome;

/**
 * @Author pan
 * @Date 2020/5/27 15:46
 * @Description 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * @Version 1.0
 **/
public class IsPalindrome {

    /**
     * 回文数
     * 相当于判断反转后是否相等
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int ori = x;
        int reverse = 0;
        int digit = 0;
        //由于是回文数说明回文之后也不会超过自身
        while (x > 0) {
            //获取最后一个位数
            digit = x % 10;
            x /= 10;
            //加到最后一位
            reverse = reverse * 10 + digit;
        }
        return ori == reverse;
    }
}
