package Sort;

/**
 * @Author PYJ
 * @Description 归并排序，采用分治思想
 * @Date 2020/4/15 23:15
 * @Version 1.0
 **/
public class MergeSort {

    public static void mergeSort(int[] values){
        int[] temp = new int[values.length]; //归并排序会有一个额外的空间处理
        mergeSort(values, 0 , values.length - 1, temp);
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
        if (left < right){
            int mid = (left + right) /2;
            //分,递归分为一小块一小块
            mergeSort(values, left, mid, temp);
            mergeSort(values, mid + 1, right, temp);
            //合，合并有特殊处理
            merge(values, left, mid, right, temp);
        }
    }

    /**
     * 合并的方法
     *
     * @param values 排序的原始数组
     * @param left 左边有序的索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
    private static void merge(int[] values, int left, int mid, int right, int[] temp) {
        int i = left; //左分离的数组索引
        int j = mid + 1; //右分离的数组索引
        int t = 0; //临时数组的下标
        //依次比较大小填充到临时数组中
        while (i <= mid && j <= right){
            if (values[i] < values[j]){
                //说明左数组比较小，则左数组的值加入临时数组，同时下标+1
                temp[t] = values[i];
                t++;
                i++;
            } else {
                temp[t] = values[j];
                t++;
                j++;
            }
        }
        //可能存在处理完成后，有一方数组未处理完的情况，进行处理
        while (i <= mid){
            temp[t] = values[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t] = values[j];
            t++;
            j++;
        }
        //处理好了数组，此时的临时变量中，数组就是有序的,复制回原数组，使其递归过程中的有序得到保存
        t = 0;
        int leftTemp = left; //需要注意复制进去的原数组下标
        while (leftTemp <= right){
            values[leftTemp] = temp[t];
            t++;
            leftTemp++;
        }
    }
}
