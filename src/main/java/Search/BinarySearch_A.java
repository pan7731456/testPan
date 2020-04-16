package Search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author pan
 * @Date 2020/4/16 18:04
 * @Description 二分查找速写
 * @Version 1.0
 **/
public class BinarySearch_A {

    public static List<Integer> binarySearch(int[] values, int value) {
        return binarySearch(values, 0, values.length - 1, value);
    }

    private static List<Integer> binarySearch(int[] values, int left, int right, int value) {
        if (left > right) {
            //未找到，直接返回空
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        //中间值
        int midVal = values[mid];
        if (value < midVal) {
            //向左递归
            return binarySearch(values, 0, mid - 1, value);
        } else if (value > midVal) {
            //右递归
            return binarySearch(values, mid + 1, right, value);
        } else {
            //说明找到了该值
            List<Integer> result = new ArrayList<>();

            //这里处理多个值的情况，返回对应的下标
            //判断右边是否有值
            int temp = mid + 1;
            while (true) {
                if (temp > right || values[temp] != midVal) {
                    break;
                }
                result.add(temp++);
            }
            //加入当前下标
            result.add(mid);
            //判断左边是否有值
            temp = mid - 1;
            while (true) {
                if (temp < left || values[temp] != midVal) {
                    break;
                }
                result.add(temp--);
            }

            return result;
        }


    }

}
