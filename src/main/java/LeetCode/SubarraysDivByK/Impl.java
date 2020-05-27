package LeetCode.SubarraysDivByK;

/**
 * @Author pan
 * @Date 2020/5/27 14:36
 * @Description
 * @Version 1.0
 **/
public class Impl {

    public static void main(String[] args) {
        int[] A = {4,5,0,-2,-3,1};
        int K = 5;
        SubarraysDivByK subarraysDivByK = new SubarraysDivByK();
        int count = subarraysDivByK.subarraysDivByK(A, K);
        System.out.println(count);
    }
}
