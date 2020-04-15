package Sort;

import java.util.Arrays;

/**
 * @Author pan
 * @Date 2020/4/15 17:44
 * @Description 快速排序 - 内部使用了递归
 * @Version 1.0
 **/
public class QuickSort {

    public static void quickSort(int[] values){
        quickSort(values, 0 ,values.length - 1);
    }

    /**
     * 快速排序
     * 使用递归
     *
     * @param values     无序数组
     * @param leftIndex  左标识
     * @param rightIndex 右标识
     */
    private static void quickSort(int[] values, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;
        /**
         * 获取中间值
         */
        int pivot = values[(leftIndex + rightIndex) / 2];
        /**
         * 临时变量
         */
        int temp = 0;
        //在里面不停的遍历，直至遍历完下标内所有数据
        while (left < right) {
            //左边找比一个比中间值要大的数据
            while (values[left] < pivot) {
                left += 1; //没找到下标+1
            }
            //右边找比中间值要小的一个数据
            while (values[right] > pivot) {
                right -= 1;
            }
            if (left >= right) {
                //说明两边数据已经分为了两份，左边小，右边大，比中间值
                break;
            }
            //否则说明找到了,需要交换
            temp = values[left];
            values[left] = values[right];
            values[right] = temp;
            //如果交换完了发现和中间值相等，那么效率处理，下标-1
            //这里先不处理
            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移

            //这个必须，报错处理
            if(values[left] == pivot) {
                right -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if(values[right] == pivot) {
                left += 1;
            }
        }
        System.out.println(Arrays.toString(values));
        //这边报错处理
        //说明至少有一个越界了，避免溢出处理
        if (left == right) {
            left += 1;
            right -= 1;
        }
        //向左递归
        if(leftIndex < right) {
            quickSort(values, leftIndex, right);
        }
        //向右递归
        if(rightIndex > left) {
            quickSort(values, left, rightIndex);
        }
    }
}
