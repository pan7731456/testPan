package Sort;

/**
 * @Author pan
 * @Date 2020/4/15 14:04
 * @Description 希尔排序 - 移位式
 * @Version 1.0
 **/
public class ShellSort {

    public static void shellSort(int[] values) {
        int temp;
        int j;
        for (int gap = values.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < values.length; i++) {
                j = i;
                temp = values[i];
                if (values[j - gap] > values[j]) {
                    while (j - gap >= 0 && temp < values[j - gap]) {
                        values[j] = values[j - gap];
                        j -= gap;
                    }
                    values[j] = temp;
                }
            }
        }


    }
}
