package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author PYJ
 * @Description 冒泡排序
 * @Date 2020/4/6 22:00
 * @Version 1.0
 **/
public class BubbleSort {
    /**
     * 进行冒牌排序
     *
     * @param values
     */
    public static void bubbleSort1(int[] values){
        /**
         * 思路分析：冒泡排序的规则是依次比较，最大的往后挪
         */
        int temp = 0; //这里变量放外面，减少新建对象，避免资源浪费
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] > values[j]){
                    //交还位置
                    temp= values[j];
                    values[j] = values[i];
                    values[i] = temp;
                }
                count++;
                //System.out.println("比较了"+ (++count) + "次");
            }
            System.out.println("第"+ (i+1)+"次比较后：");
            System.out.println(Arrays.toString(values));
        }
        System.out.println("最终比较了"+count);
    }

    public static void bubbleSort2(int[] values){
        int temp = 0; //这里变量放外面，减少新建对象，避免资源浪费
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j + 1]){
                    //交还位置
                    temp= values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
                count++;
                //System.out.println("比较了"+ (++count) + "次");
            }
            System.out.println("第"+ (i+1)+"次比较后：");
            System.out.println(Arrays.toString(values));
        }
        System.out.println("最终比较了"+count);
    }

    public static void main(String[] args) {
        int[] values = {56,78,11,1,5,20,66,103,76,100,88,41,5};
        //int[] values = new int[80000];
        //for (int i = 0; i < 80000; i++) {
        //    values[i] = (int) (Math.random()*80000);
        //}
        //long start = System.currentTimeMillis();
        System.out.println("排序前：");
        System.out.println(Arrays.toString(values));
        bubbleSort1(values);
        //long end = System.currentTimeMillis();
        //System.out.println("花费了"+ (end - start) + "ms");
        System.out.println("排序后：");
        System.out.println(Arrays.toString(values));
    }
}
