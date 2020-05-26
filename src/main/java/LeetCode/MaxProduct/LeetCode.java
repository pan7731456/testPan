package LeetCode.MaxProduct;

/**
 * @Author pan
 * @Date 2020/5/26 16:45
 * @Description 由于leetCode无法设置静态静态，因此使用动态规划的方式处理
 * @Version 1.0
 **/
public class LeetCode {

    /**
     * 惊为天人，关键点的处理非常精妙
     * 一步直接断流+保存最小值
     * 关键点在于负数，一直思路都很清晰
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        /**
         * max:最终最大数
         * imax:循环过程中最大乘积数，会因为负数和零而被还原，还原点在于前面的if (nums[i] < 0)中的处理
         * imin:循环过程中最小乘积数
         */
        int max = Integer.MIN_VALUE, imax = 1, imin = 1, tmp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                /**
                 * 如果只有一个负数，那么本身其值翻转后也起到断流的效果
                 * 同时也做到了保留负数，留待之后的再次翻转可能
                 */
                tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}
