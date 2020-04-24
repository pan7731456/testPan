package Sort;

/**
 * @Author pan
 * @Date 2020/4/24 11:14
 * @Description
 * @Version 1.0
 **/
public class InsertSort_A {
    public static void insertSort(int[] values) {
        int gap = 1;
        int index;
        int temp;
        for (int i = gap; i < values.length; i++) {
            index = i;
            temp = values[i];
            //去查找要插入的位置，这里采用移位法，使比要插入的数大的就往后移，由于前面是有序数组，因此只要比插入值大就移位到后面，最后替换就行了
            while (index - gap >= 0 && values[index - gap] > temp) {
                values[index] = values[index - gap];
                index -= gap;
            }
            if (index != i) {
                values[index] = temp;
            }
        }
    }
}
