package Sort;

/**
 * @Author pan
 * @Date 2020/4/13 11:10
 * @Description 重写选择排序
 * @Version 1.0
 **/
public class SelectSort_A {

    public static void selectSort(int[] values) {
        int temp;
        int minIndex; //要交换的位置
        for (int i = 0; i < values.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[minIndex] > values[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) { //说明有过交换
                temp = values[minIndex];
                values[minIndex] = values[i];
                values[i] = temp;
            }
        }
    }
}
