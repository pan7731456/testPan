package Sort;

/**
 * @Author pan
 * @Date 2020/4/15 17:22
 * @Description
 * @Version 1.0
 **/
public class InsertSort_E {

    public static void insertSort(int[] values){
        int gap = 1;
        int index = 0;
        int indexValue = 0;
        for (int i = gap; i < values.length; i++) {
            index = i;
            indexValue = values[i];

            while (index - gap >= 0 && indexValue < values[index - gap]){
                values[index] = values[index - gap];
                index -= gap;
            }
            if (index != i){
                values[index] = indexValue;
            }
        }
    }
}
