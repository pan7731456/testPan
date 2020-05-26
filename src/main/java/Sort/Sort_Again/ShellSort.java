package Sort.Sort_Again;

/**
 * @Author pan
 * @Date 2020/5/26 14:01
 * @Description 希尔排序
 * @Version 1.0
 **/
public class ShellSort {

    public static void shellSort(int[] values) {
        //利用插入排序 有序性效率 更高的特点
        int index;
        int temp;
        for (int gap = values.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < values.length; i++) {
                temp = values[i];
                index = i;
                while (index - gap >= 0 && temp < values[index - gap]) {
                    values[index] = values[index - gap];
                    index -= gap;
                }
                if (index != i){
                    values[index] = temp;
                }
            }
        }
    }
}
