package LeetCode.LongestCommonPrefix;

import LeetCode.MaxProduct.LeetCode;

/**
 * @Author pan
 * @Date 2020/5/27 17:11
 * @Description
 * @Version 1.0
 **/
public class LongestCommonPrefix {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                /**
                 * 由于是前缀因此不用考虑全部子字符串，因此可以这么处理
                 */
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
