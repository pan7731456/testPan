package Sort.Sort_Again;

/**
 * @Author pan
 * @Date 2020/5/26 14:15
 * @Description 快速排序，使用递归思维
 * @Version 1.0
 **/
public class QucikSort {

    public static void quickSort(int[] values) {
        quickSort(values, 0, values.length - 1);
    }

    private static void quickSort(int[] values, int left, int right) {
        //设置两个指针
        int l = left;
        int r = right;
        int temp;
        //中间值
        int povit = values[(left + right) / 2];
        //遍历其中的数据进行分拣
        while (l < r) {
            while (values[l] < povit) {
                l++;
            }
            while (values[r] > povit) {
                r--;
            }
            //跳出处理，这说明有一边已经找完了，这是最后的遍历点，再遍历就要越界了，需要跳出处理
            if (l >= r) {
                break;
            }
            //交换
            temp = values[l];
            values[l] = values[r];
            values[r] = temp;
            //这里需要跳过如果交换了中间值的位置情况
            if (values[l] == povit) {
                //说明右边遍历到了中间，然后交换了中间值，目前l是中间值
                r--;
            }
            if (values[r] == povit) {
                //同理
                l++;
            }
        }

        //避免越界处理
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
