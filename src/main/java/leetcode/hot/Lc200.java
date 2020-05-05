package leetcode.hot;

public class Lc200 {
    //给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1:
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
//
//
// 示例 2:
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
//
// Related Topics 深度优先搜索 广度优先搜索 并查集


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid.length == 0) {
                return 0;
            }

            int ans = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        ans++;
                        dfs(grid, i, j);
                    }
                }
            }

            return ans;
        }

        private void dfs(char[][] grid, int x, int y) {
            grid[x][y] = '0';
            if (x > 0 && grid[x - 1][y] == '1') {
                dfs(grid, x - 1, y);
            }
            if (x < grid.length - 1 && grid[x + 1][y] == '1') {
                dfs(grid, x + 1, y);
            }
            if (y > 0 && grid[x][y - 1] == '1') {
                dfs(grid, x, y - 1);
            }
            if (y < grid[0].length - 1 && grid[x][y + 1] == '1') {
                dfs(grid, x, y + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
