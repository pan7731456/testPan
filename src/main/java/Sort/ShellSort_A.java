package Sort;

/**
 * @Author pan
 * @Date 2020/4/24 11:24
 * @Description 希尔排序重写
 * @Version 1.0
 **/
public class ShellSort_A {
    public static void shellSort(int[] values) {
        int temp;
        int index;
        for (int gap = values.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < values.length; i++) {
                index = i;
                temp = values[i];
                while (index - gap >= 0 && values[index - gap] > temp) {
                    values[index] = values[index - gap];
                    index -= gap;
                }
                if (index != i) {
                    values[index] = temp;
                }
            }
        }
    }
}
