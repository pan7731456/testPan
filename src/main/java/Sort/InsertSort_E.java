package Sort;

/**
 * @Author pan
 * @Date 2020/4/23 18:19
 * @Description
 * @Version 1.0
 **/
public class InsertSort_E {
    public static void insertSort(int[] values) {
        int gap = 1;
        int index;
        int temp;
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
