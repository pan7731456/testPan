package Sort;

/**
 * @Author pan
 * @Date 2020/4/22 13:50
 * @Description
 * @Version 1.0
 **/
public class BubbleSort_B {
    public static void bubbleSort(int[] values) {
        int temp = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
    }
}