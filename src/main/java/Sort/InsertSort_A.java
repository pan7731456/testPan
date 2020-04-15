package Sort;

/**
 * @Author pan
 * @Date 2020/4/15 15:43
 * @Description 之前插入排序都是交换式写错了, 最快应该是移位式, 考虑如何用for写
 * @Version 1.0
 **/
public class InsertSort_A {

    public static void insertSort(int[] values) {
        int gap = 1;
        int index = 0;
        int temp = 0;
        for (int i = gap; i < values.length; i++) {
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
