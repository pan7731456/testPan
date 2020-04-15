package Sort;

import java.util.Arrays;

/**
 * @Author PYJ
 * @Description 选择排序
 * @Date 2020/4/6 22:48
 * @Version 1.0
 **/
public class SelectSort {
    /**
     * 实际定位是，假定第一个数是已排序的，后面都是没有排序的，因此需要对一个数进行比较，计算其所在的位置
     * 其实是寻找最小的数放在最前面的一个过程
     */
    public static void selectSort(int[] values){
        int temp = 0;
        int minIndex = 0; //最小值所在的下标
        for (int i = 0; i < values.length; i++) {
            minIndex = i; //假定第一个数最小
            for (int j = i + 1; j < values.length; j++) {
                if (values[minIndex] > values[j]){
                    minIndex = j;
                }
            }
            //交还数值
            if (minIndex != i) { //说明需要交还
                temp = values[i];
                values[i] = values[minIndex];
                values[minIndex] = temp;
            }
//            System.out.println("第"+ (i+1)+"次比较后：");
//            System.out.println(Arrays.toString(values));
        }
    }
}
