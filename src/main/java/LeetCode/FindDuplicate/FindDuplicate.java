package LeetCode.FindDuplicate;

/**
 * @Author pan
 * @Date 2020/5/26 17:14
 * @Description 寻找重复数
 * @Version 1.0
 **/
public class FindDuplicate {

    /**
     * 时间复杂度和空间复杂度满足了
     * 但是在提交代码后，平均时间仅击败8.74%，内存消耗击败6.67%
     */


    /**
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     */
    /**
     * 不能更改原数组（假设数组是只读的）。
     * 只能使用额外的 O(1) 的空间。-- 因此不能记录数组中的所有数据
     * 时间复杂度小于 O(n2) 。
     * 数组中只有一个重复的数字，但它可能不止重复出现一次。
     */
    public int findDuplicate(int[] nums) {
        //使用插入排序机制，同时查找对应的重复数
        return insertSortAndFind(nums);
    }

    /**
     * 插入排序处理
     *
     * @param nums
     */
    private int insertSortAndFind(int[] nums) {
        int index;
        int temp;
        for (int i = 1; i < nums.length; i++) {
            index = i;
            temp = nums[index];
            if (temp < nums[index - 1]) {
                //需要移位
                while (index - 1 >= 0 && temp < nums[index - 1]) {
                    nums[index] = nums[index - 1];
                    index--;
                }
                nums[index] = temp;
            }
            //位置已经找到，附近可能由相同的数
            if (index - 1 >= 0 && nums[index] == nums[index - 1]){
                return temp;
            }
        }
        return -1;
    }
}
