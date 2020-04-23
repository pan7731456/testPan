package Sort;

/**
 * @Author pan
 * @Date 2020/4/22 15:13
 * @Description
 * @Version 1.0
 **/
public class QuickSort_B {
    public static void quickSort(int[] values) {
        quickSort(values, 0, values.length - 1);
    }

    private static void quickSort(int[] values, int left, int right) {
        int l = left;
        int r = right;
        int pivot = values[(left + right) / 2];
        int temp = 0;

        while (l < r) {
            while (values[l] < pivot) {
                l++;
            }
            while (values[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            //说明要交换
            temp = values[l];
            values[l] = values[r];
            values[r] = temp;

            if (values[l] == pivot) {
                r--;
            }
            if (values[r] == pivot) {
                l++;
            }
        }

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
