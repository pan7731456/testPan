package LeetCode.FindDuplicate;

/**
 * @Author pan
 * @Date 2020/5/26 17:44
 * @Description
 * @Version 1.0
 **/
public class Impl {
    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        int[] nums = {3,1,3,4,2};
        int duplicate = findDuplicate.findDuplicate(nums);
        System.out.println(duplicate);
    }
}
