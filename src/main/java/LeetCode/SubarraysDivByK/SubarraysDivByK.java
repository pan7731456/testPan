package LeetCode.SubarraysDivByK;

import LeetCode.MaxProduct.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author pan
 * @Date 2020/5/27 13:50
 * @Description
 * @Version 1.0
 **/
public class SubarraysDivByK {

    /**
     * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
     *
     * 直接抄写的，内部用了同余定理，同时使用了哈希表 + 逐一计算的方式
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }
}
