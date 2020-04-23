package Sort;

/**
 * @Author pan
 * @Date 2020/4/23 18:03
 * @Description 重写插入排序
 * @Version 1.0
 **/
public class InsertSort_D {
    public static void insertSort(int[] values) {
        int gap = 1;
        int temp;
        int index;
        for (int i = gap; i < values.length; i++) { //待插入数列
            temp = values[i];
            index = i;
            while (index - gap >= 0 && values[index - gap] > values[index]) {
                values[index] = values[index - gap];
                index -= gap;
            }

            if (index != i) {
                values[index] = temp;
            }
        }
    }
}
