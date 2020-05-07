package LeetCode.LowestFare;

/**
 * @Author pan
 * @Date 2020/5/6 16:40
 * @Description
 * @Version 1.0
 **/
public class Impl {

    public static void main(String[] args) {

        LowestFare lowestFare = new LowestFare();
//        int[] days = {1, 4, 6, 7, 8, 20};
//        int[] costs = {2, 7, 15};

//        lowestFare.mincostTickets(days, costs);
//        Solution solution = new Solution();
        LowestFare_ low = new LowestFare_();

        int[] days = {1, 2, 3, 4, 6, 8, 9, 10, 13, 14, 16, 17, 19, 21, 24, 26, 27, 28, 29};
        int[] costs = {3, 14, 50};
        System.out.println(low.mincostTickets(days, costs));


    }
}
