package Sort.Sort_Again;

/**
 * @Author pan
 * @Date 2020/5/26 10:50
 * @Description 选择排序
 * @Version 1.0
 **/
public class SelectSort {

    public static void selectSort(int[] values) {
        int minIndex;
        int temp;
        for (int i = 0; i < values.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < values.length; j++) {
                //找到最小值，最后才替换
                if (values[j] < values[minIndex]) {
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
