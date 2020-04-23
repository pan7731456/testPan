package Sort;

/**
 * @Author pan
 * @Date 2020/4/22 14:23
 * @Description
 * @Version 1.0
 **/
public class QuickSort_A {

    public static void quickSort(int[] values) {
        quickSort(values, 0, values.length - 1);
    }

    /**
     * 递归实现快速排序
     *
     * @param values
     * @param left
     * @param right
     */
    private static void quickSort(int[] values, int left, int right) {
        int l = left;
        int r = right;
        //中间值
        int pivot = values[(left + right) / 2];

        int temp = 0;
        while (l < r) {

            while (values[l] < pivot) {
                l++;
            }
            while (values[r] > pivot) {
                r--;
            }
            //说明已经有序
            if (l >= r) {
                break;
            }

            //否则找到了
            temp = values[l];
            values[l] = values[r];
            values[r] = temp;

            //防止一直找到的是中间值，同时也需要处理左边较大的值，因此在这里进行处理
            if (values[l] == pivot) {
                r--;
            }
            if (values[r] == pivot) {
                l++;
            }
        }

        //避免溢出,说明要么左边越界，要么右边越界
        if (l == r) {
            l++;
            r--;
        }
        if (l < right) {
            //右递归
            quickSort(values, l, right);
        }
        if (r > left) {
            //左递归
            quickSort(values, left, r);
        }
    }
}
