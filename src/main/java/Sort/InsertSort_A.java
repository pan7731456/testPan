package Sort;

/**
 * @Author pan
 * @Date 2020/4/13 11:18
 * @Description 插入排序重写
 * @Version 1.0
 **/
public class InsertSort_A {

    public static void insertSort(int[] values) {
        int temp;
        for (int i = 1; i < values.length; i++) { //待插入数组
            for (int j = 0; j < i; j++) { //有序数组
                if (values[i] < values[j]) {
                    temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }
    }
}
