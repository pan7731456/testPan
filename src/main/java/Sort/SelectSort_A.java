package Sort;

/**
 * @Author pan
 * @Date 2020/4/22 11:16
 * @Description
 * @Version 1.0
 **/
public class SelectSort_A {

    public static void selectSort(int[] values) {
        int minIndex = 0;
        int temp = 0;
        for (int i = 0; i < values.length; i++) {
            minIndex = i; //假设第一个数最小
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < values[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
               //这时候进行交换,只交换一次
               temp = values[i];
               values[i] = values[minIndex];
               values[minIndex] = temp;
            }
        }
    }
}
