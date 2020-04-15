package Sort;

/**
 * @Author pan
 * @Date 2020/4/15 16:50
 * @Description
 * @Version 1.0
 **/
public class InsertSort_C {

    public static void insertSort(int[] values) {
        /**
         * 对应希尔排序的增量，插入排序应该默认是1
         */
        int gap = 1;
        /**
         * 用来保存目前插入的位置
         */
        int index = 0;
        /**
         * 用来保存需要插入的值
         */
        int indexValue = 0;
        for (int i = 1; i < values.length; i++) {
            index = i;
            indexValue = values[i];
            while (index - gap >= 0 && indexValue < values[index - gap]) {
                values[index] = values[index - gap];
                index -= gap;
            }
            if (index != i) { //有移位再set
                values[index] = indexValue;
            }
        }
    }

}
