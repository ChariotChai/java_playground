package leetcode.hot;

public class Lc494 {

    //给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
//
// 示例 1:
//
// 输入: nums: [1, 1, 1, 1, 1], S: 3
//输出: 5
//解释:
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
//
//
// 注意:
//
//
// 数组非空，且长度不会超过20。
// 初始的数组的和不会超过1000。
// 保证返回的最终结果能被32位整数存下。
//
// Related Topics 深度优先搜索 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            int len = 2 * sum + 1;
            int[] dp = new int[len];
            dp[nums[0] + sum] += 1;
            dp[-nums[0] + sum] += 1;

            for (int i = 1; i < nums.length; i++) {
                int[] next = new int[len];
                for (int k = -sum; k <= sum; k++) {
                    int idx = k + sum;
                    int x1 = idx + nums[i];
                    int x2 = idx - nums[i];
                    if (0 <= x1 && x1 < len) {
                        next[x1] += dp[idx];
                    }
                    if (0 <= x2 && x2 < len) {
                        next[x2] += dp[idx];
                    }
                }
                dp = next;
            }
            return Math.abs(S) > sum ? 0 : dp[S + sum];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc494().new Solution().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new Lc494().new Solution().findTargetSumWays(new int[]{1}, -1));
        System.out.println(new Lc494().new Solution().findTargetSumWays(new int[]{1, 0, 0}, -1));
    }

}
