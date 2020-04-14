package Sort;

import java.util.Arrays;

/**
 * @Author PYJ
 * @Description 希尔排序
 * @Date 2020/4/14 22:29
 * @Version 1.0
 **/
public class ShellSort_A {

    public static void shellSort(int[] values){
        int gap = values.length/2;
        boolean flag = false;
        while (gap > 0){ //增量处理
            for (int i = gap; i < values.length; i++, flag = false) {
                int j =  i - gap; //上个增量对应的数
                int value = values[i];

                //找到组中最小的数进行交换
                for (; j >= 0 && values[j] > value ; j -= gap) {
                    values[j + gap] = values[j]; //向后移
                    flag = true;
                }
                if (flag){
                    values[j + gap] = value;
                }
            }
            System.out.println(Arrays.toString(values));
            gap /= 2;
        }
    }
    public static void main(String[] args) {
        int[] values = {6, 9, 1, 4, 5, 8, 7, 0, 2, 3};

        System.out.println("排序前:  ");
        System.out.println(Arrays.toString(values));

        shellSort(values);

        System.out.println("排序后:  ");
        System.out.println(Arrays.toString(values));
    }

}
