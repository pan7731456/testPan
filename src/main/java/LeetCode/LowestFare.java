package LeetCode;

/**
 * @Author pan
 * @Date 2020/5/6 16:18
 * @Description 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * <p>
 * 火车票有三种不同的销售方式：
 * <p>
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * <p>
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 * 示例 2：
 * <p>
 * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * 输出：17
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
 * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
 * 你总共花了 $17，并完成了你计划的每一天旅行。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days 按顺序严格递增
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 **/
public class LowestFare {

    /**
     * 进行最低花费计算
     *
     * @param days  计划旅行的时间
     * @param costs 分别存储1天的通行证/7天/30天的所花费金额
     */
    public int mincostTickets(int[] days, int[] costs) {
        //空间数据准备
        int index = 0;
        //记录花费数
        int[] dayFare = new int[days[days.length - 1] + 1];
        for (int today = 1; today < dayFare.length; today++) {

            //今天是否要旅行
            if (today != days[index]) {
                dayFare[today] = dayFare[today - 1];
                //今天和昨天的花费一样，由于加了一个初始0的位置，因此不需要做特殊处理
                continue;
            }
            //去旅行了
            index++;
            dayFare[today] = (Math.min(
                    Math.min(
                            dayFare[today - 1] + costs[0],
                            dayFare[Math.max(0, today - 7)] + costs[1]),
                    dayFare[Math.max(0, today - 30)] + costs[2]
            ));
        }

        return dayFare[dayFare.length - 1];

    }
}
