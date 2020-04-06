package Sort;

import java.util.Arrays;

/**
 * @Author PYJ
 * @Description 插入排序
 * @Date 2020/4/6 23:01
 * @Version 1.0
 **/
public class InsertSort {

    public static void insertSort(int[] values){
        /**
         * 思路，形成一个有序的列表，那么其中就是有序+无序，无序的后面自动添加到前面有序对应的位置
         */

        int temp = 0;
        for (int i = 1; i < values.length; i++) { //待插入数遍历
            for (int j = 0; j < i; j++) { //有序列表
                if (values[j] > values[i]){
                    temp = values[j];
                    values[j] = values[i];
                    values[i] = temp;
                }
            }
            System.out.println("第"+ (i+1)+"次比较后：");
            System.out.println(Arrays.toString(values));
        }

    }

    public static void main(String[] args) {
        int[] values = {56,78,11,1,5,20,66,103,76,100,88,41,6};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(values));
        insertSort(values);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(values));
    }
}
