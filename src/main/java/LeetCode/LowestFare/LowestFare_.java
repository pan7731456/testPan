package LeetCode.LowestFare;

/**
 * @Author pan
 * @Date 2020/5/6 18:00
 * @Description
 * @Version 1.0
 **/
public class LowestFare_ {

    public int mincostTickets(int[] days, int[] costs) {
        //用来记录原数组中的下标
        int index = 0;
        //用于记录每天的最低花费，其中0是填充位
        int[] fare = new int[days[days.length - 1] + 1];
        for (int today = 1; today < fare.length; today++) {

            if (today != days[index]) {
                //不旅行,由于存在 0填充位 因此不需要校验
                fare[today] = fare[today - 1];
                continue;
            }
            //旅行
            index++;

            fare[today] = Math.min(Math.min(
                    fare[today - 1] + costs[0],
                    fare[Math.max(0, today - 7)] + costs[1]),
                    fare[Math.max(0, today - 30)] + costs[2]
            );
        }

        //返回最后一天的最小花费
        return fare[fare.length - 1];
    }
}
