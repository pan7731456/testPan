package Sort;

/**
 * @Author pan
 * @Date 2020/4/22 14:18
 * @Description
 * @Version 1.0
 **/
public class ShellSort_A {

    public static void shellSort(int[] values) {
        int index = 0;
        int temp = 0;
        for (int gap = values.length / 2; gap > 0; gap /= 2) {
            //走插入排序
            for (int i = gap; i < values.length; i += gap) {
                temp = values[i];
                index = i;
                while (index - gap >= 0 && temp < values[index - gap]) {
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
