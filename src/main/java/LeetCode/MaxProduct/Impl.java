package LeetCode.MaxProduct;

/**
 * @Author pan
 * @Date 2020/5/18 17:02
 * @Description
 * @Version 1.0
 **/
public class Impl {
    public static void main(String[] args) {
        LeetCode leetCode = new LeetCode();
        int[] nums = {2,3,0,-2,4};
        int max = leetCode.maxProduct(nums);
        System.out.println(max);
    }
}
