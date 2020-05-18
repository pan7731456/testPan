package LeetCode.MaxProduct;

/**
 * @Author pan
 * @Date 2020/5/18 17:02
 * @Description
 * @Version 1.0
 **/
public class Impl {
    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int[] nums = {2,3,-2,4};
        int max = maxProduct.maxProduct(nums);
        System.out.println(max);
    }
}
