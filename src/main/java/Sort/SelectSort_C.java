package Sort;

/**
 * @Author pan
 * @Date 2020/4/23 17:49
 * @Description 选择排序
 * @Version 1.0
 **/
public class SelectSort_C {
    public static void selectSort(int[] values) {
        int minIndex;
        int temp;
        for (int i = 0; i < values.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[minIndex] > values[j]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                temp = values[minIndex];
                values[minIndex] = values[i];
                values[i] = temp;
            }
        }
    }
}
