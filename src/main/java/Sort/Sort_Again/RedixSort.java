package Sort.Sort_Again;

/**
 * @Author pan
 * @Date 2020/5/26 15:53
 * @Description 基数排序
 * @Version 1.0
 **/
public class RedixSort {

    public static void redixSort(int[] values) {
        //获取最大值来设置最大位数
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        int maxLength = (max + "").length();
        //桶准备
        int[][] buckets = new int[10][values.length];
        //记录桶下标
        int[] bucketCount = new int[10];

        int index = 0;
        //起始n，gap记住
        for (int n = 0, gap = 1; n < maxLength; n++, gap *= 10) {
            //设置桶
            for (int i = 0; i < values.length; i++) {
                index = values[i] / gap % 10;
                buckets[index][bucketCount[index]++] = values[i];
            }

            //桶取出
            index = 0;
            for (int t = 0; t < 10; t++) {
                for (int count = 0; count < bucketCount[t]; count++) {
                    values[index++] = buckets[t][count];
                }
                //这里老是忘记

                //还原处理
                bucketCount[t] = 0;
            }
        }
    }
}
