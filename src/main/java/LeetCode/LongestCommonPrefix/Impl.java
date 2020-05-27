package LeetCode.LongestCommonPrefix;

/**
 * @Author pan
 * @Date 2020/5/27 17:44
 * @Description
 * @Version 1.0
 **/
public class Impl {
    public static void main(String[] args) {
        String[] values = {"flower","flow","flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String prefix = longestCommonPrefix.longestCommonPrefix(values);
        System.out.println(prefix);
    }
}
