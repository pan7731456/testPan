package Sort;

/**
 * @Author pan
 * @Date 2020/4/22 14:06
 * @Description
 * @Version 1.0
 **/
public class InsertSort_B {

    public static void insertSort(int[] values) {
        int index = 0;
        int temp = 0;
        for (int i = 1; i < values.length; i++) {
            temp = values[i];
            index = i;
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
