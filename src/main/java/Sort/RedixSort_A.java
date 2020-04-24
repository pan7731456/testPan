package Sort;

/**
 * @Author pan
 * @Date 2020/4/24 17:13
 * @Description 基数排序再跑一遍
 * @Version 1.0
 **/
public class RedixSort_A {

    public static void redixSort(int[] values) {
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        int maxLength = (max + "").length();

        int[][] buckets = new int[10][values.length];
        int[] bucketCount = new int[10];
        for (int x = 0, n = 1; x < maxLength; x++, n *= 10) {
            for (int i = 0; i < values.length; i++) {
                int bucket = values[i] / n % 10;
                buckets[bucket][bucketCount[bucket]++] = values[i];
            }

            //桶中取出保证排序
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
