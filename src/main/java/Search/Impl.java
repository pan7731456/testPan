package Search;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static Search.BinarySearch_A.binarySearch;
import static Sort.RedixSort.redixSort;
import static Sort.ValuesArray.valuesArray;

/**
 * @Author pan
 * @Date 2020/4/16 17:38
 * @Description 查找测试类
 * @Version 1.0
 **/
public class Impl {
    public static void main(String[] args) {
//        int[] valuesArray = valuesArray(20);
        int[] valuesArray = {1,1,1,1,1,1,21,1,3,4,5,6,8};
        System.out.println("排序前——————");
        System.out.println(Arrays.toString(valuesArray));
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        redixSort(valuesArray);
        System.out.println("排序后——————");
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
        System.out.println(Arrays.toString(valuesArray));

        //查找数据
        int value = 1;

        System.out.println("查找" + value + "所在的位置:" + binarySearch(valuesArray, value));

    }
}
