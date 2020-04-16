package Sort;

import java.util.Random;

/**
 * @Author pan
 * @Date 2020/4/13 11:05
 * @Description 获取随机数的数组
 * @Version 1.0
 **/
public class ValuesArray {

    public static int[] valuesArray(int max) {
        Random random = new Random();
        int[] values = new int[max];
        for (int i = 0; i < max; i++) {
            values[i] = random.nextInt(10000);
        }
        return values;
    }
}
