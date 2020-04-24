package Sort;

/**
 * @Author pan
 * @Date 2020/4/24 10:53
 * @Description
 * @Version 1.0
 **/
public class SelectSort_A {
    public static void selectSort(int[] values) {
        int min;
        int temp;
        for (int i = 0; i < values.length; i++) {
            min = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < values[min]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = values[min];
                values[min] = values[i];
                values[i] = temp;
            }
        }
    }
}
