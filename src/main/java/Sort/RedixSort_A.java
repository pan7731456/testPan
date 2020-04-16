package Sort;

/**
 * @Author pan
 * @Date 2020/4/16 10:55
 * @Description 基数排序
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
        //数据准备
        int[][] buckets = new int[10][values.length];
        //存放
        int[] bucketCount = new int[10];
        for (int gap = 0, n = 1; gap < maxLength; gap++, n *= 10) {

            //桶设置
            for (int i = 0; i < values.length; i++) {
                int bucket = values[i] / n % 10; //获取桶编号
                buckets[bucket][bucketCount[bucket]++] = values[i];//加入桶
            }
            //取出桶形成一定程度的有序
            //遍历所有桶
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
