package Sort;

/**
 * @Author pan
 * @Date 2020/4/15 17:15
 * @Description 移位式 插入排序
 * @Version 1.0
 **/
public class InsertSort_D {

    public static void insertSort(int[] values) {
        int gap = 1;
        int index = 0;
        int indexValue = 0;

        for (int i = gap; i < values.length; i++) {
            index = i;
            indexValue = values[i];
            while (index - gap >= 0 && indexValue < values[index - gap]) {
                //移位
                values[index] = values[index - gap];
                index -= gap;
            }
            if (index != i) {
                //说明移位了
                values[index] = indexValue;
            }
        }
    }
}
