package LeetCode.MaxProduct;

import java.util.ArrayList;

/**
 * @Author pan
 * @Date 2020/5/18 16:35
 * @Description 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * @Version 1.0
 **/
public class MaxProduct {

    /**
     * 自己写的递归解法，未通过倒数第二个用例，判断耗时过长
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = 0;
        int indexMax = 0;
        for (int i = 0; i < nums.length; i++) {
            indexMax = recursiveMultiplication(nums, nums.length, i, nums[i], nums[i]);
            if (i == 0 || max < indexMax) { //需要初始化
                max = indexMax;
            }
        }
        return max;
    }

    /**
     * 数组遍历去计算最大值
     *
     * @param nums   数组
     * @param length 数组长度,效率处理
     * @param i      数组下标
     * @param max    最大值
     * @param result 乘积
     */
    private int recursiveMultiplication(int[] nums, int length, int i, int max, int result) {
        if (max < result) {
            max = result;
        }
        if (i + 1 < length) {
            return recursiveMultiplication(nums, length, i + 1, max, result * nums[i + 1]);
        }
        return max;
    }
}
