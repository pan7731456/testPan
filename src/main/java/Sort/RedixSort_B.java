package Sort;

/**
 * @Author pan
 * @Date 2020/4/16 13:48
 * @Description 基数排序复写
 * @Version 1.0
 **/
public class RedixSort_B {

    public static void redixSort(int[] values) {
        //找到最大值
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
            for (int i = 0; i < values.length; i++) {
                int bucket = values[i] / n % 10;
                buckets[bucket][bucketCount[bucket]++] = values[i];
            }

            //取数据
            for (int i = 0, index = 0; i < bucketCount.length; i++) {
                for (int j = 0; j < bucketCount[i]; j++) {
                    values[index++] = buckets[i][j];
                }
                //置空处理
                bucketCount[i] = 0;
            }


        }

    }
}
