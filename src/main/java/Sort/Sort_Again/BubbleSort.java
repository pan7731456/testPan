package Sort.Sort_Again;

/**
 * @Author pan
 * @Date 2020/5/19 15:17
 * @Description 重写冒泡排序
 * @Version 1.0
 **/
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param values
     */
    public static void bubbleSort(int[] values) {
        int temp;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    temp = values[j + 1];
                    values[j + 1] = values[j];
                    values[j] = temp;
                }
            }
        }
    }
}
