package leetcode.hot;

import java.util.Arrays;

public class Lc322 {

    //给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
//
//
// 示例 1:
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3
//解释: 11 = 5 + 5 + 1
//
// 示例 2:
//
// 输入: coins = [2], amount = 3
//输出: -1
//
//
//
// 说明:
//你可以认为每种硬币的数量是无限的。
// Related Topics 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            int[] dp = new int[amount + 1];

            for (int i = 1; i <= amount; i++) {
                int min = -1;
                for (int coin : coins) {
                    int remains = i - coin;
                    if (remains < 0) {
                        break;
                    }
                    if (remains == 0) {
                        min = 0;
                        break;
                    }
                    if (dp[remains] >= 0) {
                        min = min == -1 ? dp[remains] : Math.min(min, dp[remains]);
                    }
                }
                dp[i] = min == -1 ? -1 : min + 1;
            }

            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc322().new Solution().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new Lc322().new Solution().coinChange(new int[]{3}, 10));
        System.out.println(new Lc322().new Solution().coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

}