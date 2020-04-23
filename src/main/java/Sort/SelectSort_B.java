package Sort;

/**
 * @Author pan
 * @Date 2020/4/22 13:53
 * @Description
 * @Version 1.0
 **/
public class SelectSort_B {
    public static void selectSort(int[] values) {
        int minIndex = 0;
        int temp = 0;
        for (int i = 0; i < values.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[minIndex] > values[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = values[minIndex];
                values[minIndex] = values[i];
                values[i] = temp;
            }
        }
    }
}
