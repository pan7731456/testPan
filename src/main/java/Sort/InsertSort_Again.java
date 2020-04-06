package Sort;

import java.util.Arrays;

/**
 * @Author PYJ
 * @Description 插入排序_复写
 * @Date 2020/4/6 23:20
 * @Version 1.0
 **/
public class InsertSort_Again {

    public static void insertSort(int[] values){
        int temp = 0;
        for (int i = 1; i < values.length; i++) { //需要插入的数，需要判断插入的位置
            for (int j = 0; j < i; j++) { //已经形成序列的数组，和待插入数比较
                if (values[i] < values[j]){
                    temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
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
