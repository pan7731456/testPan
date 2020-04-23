package Sort;

/**
 * @Author pan
 * @Date 2020/4/23 17:27
 * @Description
 * @Version 1.0
 **/
public class MergeSort_B {

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
        //分
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(values, left, mid, temp);
            mergeSort(values, mid + 1, right, temp);
            merge(values, left, mid, right, temp);
        }
    }

    private static void merge(int[] values, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0;
        while (l <= mid && r <= right) {
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
        while (index <= right) {
            values[index++] = temp[t++];
        }
    }
}
