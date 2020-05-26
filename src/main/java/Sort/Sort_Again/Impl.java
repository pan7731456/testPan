package Sort.Sort_Again;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static Sort.Sort_Again.BubbleSort.bubbleSort;
import static Sort.Sort_Again.InsertSort.insertSort;
import static Sort.Sort_Again.MergeSort_A.mergeSort;
import static Sort.Sort_Again.QucikSort.quickSort;
import static Sort.Sort_Again.RedixSort.redixSort;
import static Sort.Sort_Again.SelectSort.selectSort;
import static Sort.Sort_Again.ShellSort.shellSort;
import static Sort.ValuesArray.valuesArray;

/**
 * @Author pan
 * @Date 2020/5/19 15:17
 * @Description
 * @Version 1.0
 **/
public class Impl {
    public static void main(String[] args) {
        int[] valuesArray = valuesArray(20);
        //int[] valuesArray = {4,4,4,4,3,1,1,1,1};
        System.out.println("排序前——————");
        System.out.println(Arrays.toString(valuesArray));
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是: " + date1Str);
        redixSort(valuesArray);
        System.out.println("排序后——————");
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是: " + date2Str);
        System.out.println(Arrays.toString(valuesArray));
    }
}