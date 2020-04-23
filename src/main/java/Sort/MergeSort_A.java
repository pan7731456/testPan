package Sort;

/**
 * @Author pan
 * @Date 2020/4/23 15:48
 * @Description
 * @Version 1.0
 **/
public class MergeSort_A {

    public static void mergeSort(int[] values) {
        //归并排序
        int[] temp = new int[values.length];
        mergeSort(values, 0, values.length - 1, temp);
    }

    /**
     * 归并排序
     *
     * @param values
     * @param left
     * @param right
     * @param temp
     */
    private static void mergeSort(int[] values, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(values, left, mid, temp);
            mergeSort(values, mid + 1, right, temp);

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
     * @param temp
     */
    private static void merge(int[] values, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0; //临时数组下标
        //假设两个数组进行合并
        while (l <= mid && r <= right) {
            //判断那个数大，先放到中间数组
            if (values[l] < values[r]) {
                temp[t++] = values[l++];
            } else {
                temp[t++] = values[r++];
            }
        }
        //这时候只有一个分组被分完，继续加入
        while (l <= mid) {
            temp[t++] = values[l++];
        }
        while (r <= right) {
            temp[t++] = values[r++];
        }
        t = 0;
        int index = left;
        while (index <= right) {
            values[index++] = temp[t++];
        }
    }
}
