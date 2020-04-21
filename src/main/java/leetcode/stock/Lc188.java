package leetcode.stock;

public class Lc188 {

    //给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
// 示例 1:
//
// 输入: [2,4,1], k = 2
//输出: 2
//解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
//
//
// 示例 2:
//
// 输入: [3,2,6,5,0,3], k = 2
//输出: 7
//解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3
//。
//
// Related Topics 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices.length <= 1) {
                return 0;
            }

            if (k >= prices.length / 2) {
                int sum = 0;
                for (int i = 1; i < prices.length; i++) {
                    int diff = prices[i] - prices[i-1];
                    if (diff > 0) {
                        sum += diff;
                    }
                }
                return sum;
            }

            int[] x = new int[prices.length];
            int[] y = new int[prices.length];
            x[0] = -prices[0];
            int lasty;
            int tmpx;
            int last = 0;
            for (int t = 1; t <= k; t++) {
                lasty = y[0];
                int size = Math.max(1, prices.length - k + t);
                for (int i = 1; i < size; i++) {
                    tmpx = x[i - 1];
                    x[i] = Math.max(tmpx, lasty - prices[i]);
                    lasty = y[i];
                    y[i] = Math.max(y[i - 1], tmpx + prices[i]);
                }
                if (size == prices.length && last >= y[prices.length - 1]) {
                    break;
                }
                last = y[prices.length - 1];
            }

            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc188().new Solution().maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(new Lc188().new Solution().maxProfit(10, new int[]{3, 2, 6, 5, 0, 3}));
    }

}
