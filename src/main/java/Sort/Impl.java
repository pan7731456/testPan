package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static Sort.BubbleSort.bubbleSort;
//import static Sort.InsertSort.insertSort;
import static Sort.InsertSort_A.insertSort;
import static Sort.SelectSort.selectSort;
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
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        System.out.println(Arrays.toString(valuesArray));
        insertSort(valuesArray);
        System.out.println("排序后——————");
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
        System.out.println(Arrays.toString(valuesArray));
    }
}
