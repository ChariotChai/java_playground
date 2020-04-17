package leetcode.stock;

import com.alibaba.fastjson.JSON;

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

            k = Math.min(k, prices.length / 2);

            int[][] a = new int[k + 1][];
            int[][] b = new int[k + 1][];
            a[0] = new int[prices.length];
            b[0] = new int[prices.length];

            for (int t = 1; t <= k; t++) {
                a[t] = new int[prices.length];
                b[t] = new int[prices.length];
                a[t][0] = -prices[0];
                for (int i = 1; i < prices.length; i++) {
                    a[t][i] = Math.max(a[t][i - 1], b[t - 1][i - 1] - prices[i]);
                    b[t][i] = Math.max(a[t][i - 1] + prices[i], b[t][i - 1]);
                }
            }
            System.out.println(JSON.toJSONString(b));

            int x = 0;
            int[] y = new int[prices.length];
            for (int t = 1; t <= k; t++) {
                x = -prices[0];
                int tmpY = y[0];
                for (int i = 1; i < prices.length; i++) {
                    int tmpX = x;
                    x = Math.max(tmpX, tmpY - prices[i]);
                    if (i > 1) {
                        tmpY = y[i - 2];
                    }
                    y[i] = Math.max(tmpX + prices[i], y[i]);
                    System.out.println("~~ " + tmpY + " ~~ t = " + t + " ~~ i = " + i);
                }
                System.out.println("~~" + JSON.toJSONString(y));
            }
            return b[k][prices.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc188().new Solution().maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(new Lc188().new Solution().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

}
