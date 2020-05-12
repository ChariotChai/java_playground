package leetcode.hot;

public class Lc279 {
    //给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
// 示例 1:
//
// 输入: n = 12
//输出: 3
//解释: 12 = 4 + 4 + 4.
//
// 示例 2:
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9.
// Related Topics 广度优先搜索 数学 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int min = -1;
                int k = 1;
                int kk = 1;
                while (kk <= i) {
                    if (dp[i - kk] < min || min < 0) {
                        min = dp[i - kk];
                    }
                    k++;
                    kk = k * k;
                }
                dp[i] = min + 1;
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc279().new Solution().numSquares(1));
        System.out.println(new Lc279().new Solution().numSquares(9));
        System.out.println(new Lc279().new Solution().numSquares(12));
        System.out.println(new Lc279().new Solution().numSquares(13));
    }

}
