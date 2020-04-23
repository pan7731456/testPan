package Sort;

/**
 * @Author pan
 * @Date 2020/4/22 13:56
 * @Description 重写插入排序
 * @Version 1.0
 **/
public class InsertSort_A {

    public static void insertSort(int[] values) {

        int index = 0;
        int temp = 0;
        //移位法
        for (int i = 1; i < values.length; i++) {
            temp = values[i];
            index = i;
            while (index - 1 >= 0 && values[index - 1] > temp) {
                values[index] = values[index - 1];
                index--;
            }
            if (index != i) {
                values[index] = temp;
            }
        }
    }
}
