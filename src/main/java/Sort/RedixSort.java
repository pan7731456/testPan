package Sort;

import java.util.Arrays;

/**
 * @Author PYJ
 * @Description 基数排序
 * @Date 2020/4/15 23:49
 * @Version 1.0
 **/
public class RedixSort {
    /**
     * 思路分为10个数组，其中存放 0-9的计算下标，依次比较后，自然形成了有序数组
     */
    public static void redixSort(int[] values) {
        int max = 0; //最大值
        //首先获取到最大的位数,判断需要循环多少次,这里占了n次计算
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        //最大值判断最大位数
        int maxLength = (max + "").length();
        //基数排序数据准备
        int[][] buckets = new int[10][values.length]; //设置10个桶对应 0-9 下标
        int[] bucketCount = new int[10]; //设置数组保存对应桶中的有效数据量

        for (int gap = 0, n = 1; gap < maxLength; gap++, n *= 10) {
            for (int i = 0; i < values.length; i++) {
                int bucket = values[i] / n % 10; //下标
                buckets[bucket][bucketCount[bucket]] = values[i]; //该数存放到对应的桶中
                bucketCount[bucket]++; //桶中有效数字+1
            }
            int index = 0;
            for (int k = 0; k < bucketCount.length; k++) {
                for (int l = 0; l < bucketCount[k]; l++) {
                    //说明有数据
                    values[index++] = buckets[k][l];
                }

                bucketCount[k] = 0; //置空处理
            }
            System.out.println(Arrays.toString(values));
        }
    }
}
