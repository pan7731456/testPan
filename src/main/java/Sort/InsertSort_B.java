package Sort;

/**
 * @Author pan
 * @Date 2020/4/15 16:16
 * @Description 移位法插入排序
 * @Version 1.0
 **/
public class InsertSort_B {

    public static void insertSort(int[] values) {
        int gap = 1;
        int index = 0;
        int indexValue = 0;
        for (int i = 1; i < values.length; i++) {
            index = i;
            indexValue = values[index];
            while (index - gap >= 0 && indexValue < values[index - gap]) {
                values[index] = values[index - gap];
                index -= gap;
            }
            if (index != i){
                values[index] = indexValue;
            }
        }
    }
}
