package Sort.Sort_Again;

/**
 * @Author pan
 * @Date 2020/5/26 15:53
 * @Description 归并算法再写一次
 * @Version 1.0
 **/
public class MergeSort_A {

    public static void mergeSort(int[] values) {
        int[] temp = new int[values.length];
        mergeSort(values, 0, values.length - 1, temp);
    }

    /**
     * 归并算法
     *
     * @param values
     * @param left
     * @param right
     * @param temp
     */
    private static void mergeSort(int[] values, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //分
            mergeSort(values, left, mid, temp);
            mergeSort(values, mid + 1, right, temp);
            //合
            merge(values, left, mid, right, temp);
        }
    }

    /**
     * 合并数据
     *
     * @param values
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    private static void merge(int[] values, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        //中转数组下标
        int t = 0;

        while (l <= mid && r <= right) {
            if (values[l] < values[r]) {
                temp[t++] = values[l++];
            } else {
                temp[t++] = values[r++];
            }
        }
        //还剩下的数据给加在尾部
        while (l <= mid) {
            temp[t++] = values[l++];
        }
        while (r <= right) {
            temp[t++] = values[r++];
        }
        //中转数据已经有序了,这时候重新设置原始数组有序
        t = 0;
        int index = left;
        while (index <= right) {
            values[index++] = temp[t++];
        }
    }
}
