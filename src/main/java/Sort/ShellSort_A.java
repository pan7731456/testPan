package Sort;

/**
 * @Author pan
 * @Date 2020/4/15 17:27
 * @Description 希尔排序 移位法
 * @Version 1.0
 **/
public class ShellSort_A {

    // 希尔排序，本质就是选择性的插入排序
    public static void shellSort(int[] values) {
        int index = 0;
        int indexValue = 0;
        for (int gap = values.length / 2; gap > 0; gap /= 2) {
            // 内部插入排序
            for (int i = gap; i < values.length; i++) {
                index = i;
                indexValue = values[i];
                while (index - gap >= 0 && indexValue < values[index - gap]) {
                    values[index] = values[index - gap];
                    index -= gap;
                }
                if (index != i) {
                    values[index] = indexValue;
                }
            }
        }
    }
}
