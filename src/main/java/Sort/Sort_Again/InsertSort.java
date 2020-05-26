package Sort.Sort_Again;

/**
 * @Author pan
 * @Date 2020/5/26 10:57
 * @Description 插入排序, 移位式(重点)
 * @Version 1.0
 **/
public class InsertSort {

    public static void insertSort(int[] values) {
        //有序+无序的计算
        int index;
        int temp;
        for (int i = 1; i < values.length; i++) {
            index = i;
            temp = values[i];
            while (index - 1 >= 0 && temp < values[index - 1]) {
                values[index] = values[index - 1];
                index--;
            }
            if (index != i) {
                values[index] = temp;
            }
        }
    }
}
