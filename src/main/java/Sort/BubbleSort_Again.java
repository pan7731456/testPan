package Sort;

import java.util.Arrays;

/**
 * @Author PYJ
 * @Description 实现冒泡排序
 * @Date 2020/4/6 22:17
 * @Version 1.0
 **/
public class BubbleSort_Again {
    /**
     * 规则分析：找到最大的数，从左到右找到大的数，依次比较，如果数大则交换位置，如果数小
     */
    public static void bubbleSort(int[] values){
        int temp = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j + 1]){
                    temp = values[j + 1];
                    values[j + 1] = values[j];
                    values[j] = temp;
                }
            }
            System.out.println("第"+ (i+1)+"次比较后：");
            System.out.println(Arrays.toString(values));
        }
    }

    public static void main(String[] args) {
        int[] values = {56,78,11,1,5,20,66,103,76,100,88,41,5};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(values));
        bubbleSort(values);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(values));
    }
}
