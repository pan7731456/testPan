package Search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author pan
 * @Date 2020/4/16 16:30
 * @Description 二分查找
 * @Version 1.0
 **/
public class BinarySearch {
    /**
     * 二分查找只针对有序数组
     */
    public static List<Integer> binarySearch(int[] values, int value) {
        return binarySearch(values, 0, values.length - 1, value);
    }

    /**
     * 二分查找，使用递归
     *
     * @param values 原数组
     * @param left   左索引
     * @param right  右索引
     * @param value  寻找的值
     * @return 查找到的下标，否则返回-1
     */
    private static List<Integer> binarySearch(int[] values, int left, int right, int value) {
        //说明没找到
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = values[mid]; //中间值
        //说明比中间值要小
        if (value < midVal) {
            return binarySearch(values, left, mid - 1, value);
        } else if (value > midVal) {
            return binarySearch(values, mid + 1, right, value);
        } else {
            List<Integer> result = new ArrayList<>();
            //说明找到了，这时候，需要去判断是否有多个值，这时候分不清是左边相等，还是右边相等
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || values[temp] != value) {
                    break;
                }
                //否则，就temp 放入到 resIndexlist
                result.add(temp);
                temp--;
            }
            result.add(mid);

            //向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            temp = mid + 1;
            while (true) {
                if (temp > values.length - 1 || values[temp] != value) {
                    break;
                }
                //否则，就temp 放入到 resIndexlist
                result.add(temp);
                temp++;
            }

            return result;
        }
    }
}
