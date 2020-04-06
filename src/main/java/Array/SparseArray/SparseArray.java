package Array.SparseArray;

import java.util.Arrays;

/**
 * @Author PYJ
 * @Description 手写二维数组转稀疏数组
 * @Date 2020/4/616:31
 * @Version 1.0
 **/
public class SparseArray {
    /**
     * 稀疏数组的定义,过滤出二维数组中非零的常量项,然后保存在一个3列的二维数组中相当于压缩空间
     * 应用场景只有在有大量0的二维数组中为了节省空间而使用
     */

    public static void main(String[] args) {
        //先定义一个二维数组
        int [][] nums = new int[11][12];
        //模拟五子棋,1代表黑子先下,2代表白子,实现保存功能,但是棋局有大量空白,这时候需要转换为稀疏数组保存结果
        nums[1][2] = 1;
        nums[7][10] = 2;
        nums[7][11] = 1;
        System.out.println("二维数组:");
        printArray(nums);
        int[][] spraseArray = convertSpraseArray(nums);
        System.out.println("转化后的稀疏数组为:");
        printArray(spraseArray);
    }

    /**
     * 转化为稀疏数组
     *
     * @param nums 原始二维数组
     * @return
     */
    private static int[][]  convertSpraseArray(int[][] nums) {
        //获取非零的数字,用来创建稀疏数组
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] != 0){
                    sum++;
                }
            }
        }
        int[][] spraseArray = new int[sum + 1][3];
        spraseArray[0][0] = nums.length;
        spraseArray[0][1] = nums[0].length;
        spraseArray[0][2] = sum;

        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] != 0){
                    spraseArray[count][0] = i;
                    spraseArray[count][1] = j;
                    spraseArray[count][2] = nums[i][j];
                    count++;
                }
            }
        }
        return spraseArray;
    }

    /**
     * 打印二维数组
     *
     * @param nums
     */
    private static void printArray(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}
