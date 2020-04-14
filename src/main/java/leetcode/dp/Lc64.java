package leetcode.dp;

public class Lc64 {

    //给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
// 示例:
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
//
// Related Topics 数组 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int y = grid.length;
            int x = grid[0].length;
            int[][] dp = new int[y][];
            for (int i = 0; i < y; i++) {
                dp[i] = new int[x];
            }

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = grid[i][j];
                    } else if (i == 0 && j != 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    } else if (i != 0 && j == 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                    }
                }
            }

            return dp[y - 1][x - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        int[][] a = new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1},
        };
        System.out.println(new Lc64().new Solution().minPathSum(a));
    }

}
