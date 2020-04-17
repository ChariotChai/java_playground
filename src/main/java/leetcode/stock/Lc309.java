package leetcode.stock;

public class Lc309 {

    //给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//
//
// 示例:
//
// 输入: [1,2,3,0,2]
//输出: 3
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
// Related Topics 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int a = -prices[0];
            int b = 0, c = 0;

            for (int i = 1; i < prices.length; i++) {
                int tmpA = a;
                a = Math.max(a, b - prices[i]);
                b = Math.max(b, c);
                c = tmpA + prices[i];
            }

            return Math.max(b, c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc309().new Solution().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

}
