package Sort;

import java.util.Arrays;

import static Sort.BubbleSort_A.bubbleSort;
import static Sort.InsertSort_A.insertSort;
import static Sort.SelectSort_A.selectSort;
import static Sort.ValuesArray.valuesArray;

/**
 * @Author pan
 * @Date 2020/4/13 11:05
 * @Description
 * @Version 1.0
 **/
public class Impl {
    public static void main(String[] args) {
        int[] valuesArray = valuesArray(10);
        System.out.println("排序前——————");
        System.out.println(Arrays.toString(valuesArray));
        insertSort(valuesArray);
        System.out.println("排序后——————");
        System.out.println(Arrays.toString(valuesArray));
    }
}
