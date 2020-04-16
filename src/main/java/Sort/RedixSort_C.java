package Sort;

/**
 * @Author pan
 * @Date 2020/4/16 14:57
 * @Description 基数排序复写
 * @Version 1.0
 **/
public class RedixSort_C {
    public static void redixSort(int[] values) {
        //获取最大位数
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (max < values[i]) {
                max = values[i];
            }
        }
        int maxLength = (max + "").length();
        //数据准备
        int[][] buckets = new int[10][values.length];
        int[] bucketCount = new int[10];

        for (int gap = 0, n = 1; gap < maxLength; gap++, n *= 10) {
            //放入桶中
            for (int i = 0; i < values.length; i++) {
                int bucket = values[i] / n % 10; //获取对应桶位置
                buckets[bucket][bucketCount[bucket]++] = values[i];
            }
            //桶中取出
            for (int i = 0, index = 0; i < bucketCount.length; i++) {
                //桶中有数据才取出
                for (int j = 0; j < bucketCount[i]; j++) {
                    values[index++] = buckets[i][j];
                }
                //置空
                bucketCount[i] = 0;
            }
        }
    }
}
