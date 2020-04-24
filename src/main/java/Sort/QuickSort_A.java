package Sort;

/**
 * @Author pan
 * @Date 2020/4/24 11:31
 * @Description 快速排序
 * @Version 1.0
 **/
public class QuickSort_A {

    public static void quickSort(int[] values) {
        quickSort(values, 0, values.length - 1);
    }

    /**
     * 快速排序
     *
     * @param values
     * @param left
     * @param right
     */
    private static void quickSort(int[] values, int left, int right) {
        int l = left;
        int r = right;
        int pivot = values[(left + right) / 2];

        int temp;
        while (l < r) {
            while (values[l] < pivot) {
                l++;
            }
            while (values[r] > pivot) {
                r--;
            }
            //已完成排序
            if (l >= r) {
                break;
            }
            //交换
            temp = values[l];
            values[l] = values[r];
            values[r] = temp;
            //这里靠背的，理解是需要避免死循环
            if (values[l] == pivot) {
                r--;
            }
            if (values[r] == pivot) {
                l++;
            }
        }

        //死背，避免报错
        if (l == r) {
            l++;
            r--;
        }
        if (l < right) {
            quickSort(values, l, right);
        }
        if (r > left) {
            quickSort(values, left, r);
        }
    }
}
