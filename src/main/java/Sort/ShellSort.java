package Sort;

import java.util.Arrays;

/**
 * @Author PYJ
 * @Description 希尔排序
 * @Date 2020/4/14 21:40
 * @Version 1.0
 **/
public class ShellSort {

    /**
     * 希尔排序是处理大量数据的，实际情况不应该是匹配到就交换，而是最后确认到最小值然后交换
     * 将匹配划分为几块，然后进行排序
     *
     * @param values
     */
    public static void shellSort(int[] values){
        // 定义希尔增量。
        int gap = values.length / 2;
        boolean flag = false;
        // gap缩小到0的时候就退出循环。
        while (gap > 0) {
            // 每组进行直接插入排序。
            for (int i = gap; i < values.length; i++, flag =false) {    // i 代表待插入元素的索引。
                int value = values[i];
                int j = i - gap;    // j 代表i的上一个元素，相差一个增量gap。
                // j < 0 时退出循环，说明 j 是最小的元素的索引值。
                // 或者 arr[j] <= value 时退出循环，说明 j 是比value小的元素的索引值。
                for (; j >= 0 && values[j] > value; j -= gap) {
                    values[j + gap] = values[j];  // 把元素往后挪。
                    flag = true;
                }
                if (flag){
                    values[j + gap] = value;
                }
            }
            // 把每一趟排序的结果也输出一下。
            System.out.println(Arrays.toString(values));

            // 缩小增量。
            gap /= 2;
        }
    }


    public static void main(String[] args) {
        int[] values = {6, 9, 1, 4, 5, 8, 7, 0, 2, 3};

        System.out.println("排序前:  ");
        System.out.println(Arrays.toString(values));

        shellSort(values);

        System.out.println("排序后:  ");
        System.out.println(Arrays.toString(values));
    }
}
