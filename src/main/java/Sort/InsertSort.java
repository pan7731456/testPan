package Sort;

import java.util.Arrays;

/**
 * @Author PYJ
 * @Description 插入排序
 * @Date 2020/4/6 23:01
 * @Version 1.0
 **/
public class InsertSort {

    public static void insertSort(int[] values) {
        /**
         * 思路，形成一个有序的列表，那么其中就是有序+无序，无序的后面自动添加到前面有序对应的位置
         */

        int temp = 0;
        int index = 0;
        for (int i = 1; i < values.length; i++) { //待插入数遍历
            temp = values[i];
            index = i;
            while (index - 1 >= 0 && temp < values[index - 1]) { //类似希尔排序,gap = 1
                values[index] = values[index - 1];
                index--;
            }
            if (index != i) {
                values[index] = temp;
            }
        }

    }
}
