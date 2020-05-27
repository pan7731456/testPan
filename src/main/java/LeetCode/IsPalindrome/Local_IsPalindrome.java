package LeetCode.IsPalindrome;

/**
 * @Author pan
 * @Date 2020/5/27 16:04
 * @Description
 * @Version 1.0
 **/
public class Local_IsPalindrome {
    /**
     * 官方解法，只反转一般数据
     * 原因：避免溢出，实际上溢出就一定会是负数，这里有个盲点
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int a = 0;
        while (x > a) {
            a = a * 10 + x % 10;
            x = x / 10;
        }
        return x == a || x == a / 10;
    }
}
