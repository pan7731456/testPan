package Sort;

/**
 * @Author pan
 * @Date 2020/4/24 13:42
 * @Description 归并排序
 * @Version 1.0
 **/
public class MergeSort_A {

    public static void mergeSort(int[] values) {
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
        //temp中已经有有序的数组了
        t = 0;
        int index = left; //原数组下标
        while (index <= right) {
            values[index++] = temp[t++];
        }
    }
}
