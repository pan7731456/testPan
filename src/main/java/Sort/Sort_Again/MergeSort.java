package Sort.Sort_Again;

/**
 * @Author pan
 * @Date 2020/5/26 14:56
 * @Description 归并排序
 * @Version 1.0
 **/
public class MergeSort {

    public static void mergeSort(int[] values) {
        //需要准备中间数组
        int[] temp = new int[values.length];
        mergeSort(values, 0, values.length - 1, temp);
    }

    /**
     * 分治法
     *
     * @param values
     * @param left
     * @param right
     * @param temp
     */
    private static void mergeSort(int[] values, int left, int right, int[] temp) {
        if (left < right) {
            //分离
            int mid = (left + right) / 2;
            mergeSort(values, left, mid, temp);
            mergeSort(values, mid + 1, right, temp);
            //合并
            merge(values, left, mid, right, temp);
        }
    }

    /**
     * 合并
     *
     * @param values
     * @param left
     * @param mid
     * @param right
     * @param temp 中转数组，递归不是多线程，因此不需要考虑中转数组的数据位置，在多线程情况下应该会冲突，如果t都为0的话
     */
    private static void merge(int[] values, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;

        int t = 0;
        while (l <= mid && r <= right) {
            //比较
            if (values[l] < values[r]) {
                temp[t++] = values[l++];
            } else {
                temp[t++] = values[r++];
            }
        }
        while (l <= mid) {
            temp[t++] = values[l++];
        }
        while (r <= right) {
            temp[t++] = values[r++];
        }
        t = 0;
        int index = left;
        //这时候需要从中转数据中拿回排序后的数据
        while (index <= right) {
            values[index++] = temp[t++];
        }
    }
}
