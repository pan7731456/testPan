package Sort;

/**
 * @Author pan
 * @Date 2020/4/23 18:29
 * @Description 基数排序
 * @Version 1.0
 **/
public class RedixSort_A {
    public static void redixSort(int[] values) {
        int[][] buckets = new int[10][values.length];
        int[] bucketCount = new int[10];

        //获取最大值来获取最大位数
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        //得到最大值后设置最大位数
        int maxLength = (max + "").length();
        for (int x = 0, n = 1; x < maxLength; x++, n *= 10) {
            for (int i = 0; i < values.length; i++) {
                int bucket = values[i] / n % 10;
                //放入桶中
                buckets[bucket][bucketCount[bucket]++] = values[i];
            }
            //桶中拿出复位位置
            int index = 0;
            for (int i = 0; i < bucketCount.length; i++) {
                for (int j = 0; j < bucketCount[i]; j++) {
                    values[index++] = buckets[i][j];
                }
                bucketCount[i] = 0;
            }
        }
    }
}
