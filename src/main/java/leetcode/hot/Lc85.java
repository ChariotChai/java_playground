package leetcode.hot;

public class Lc85 {
    //给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
// 示例:
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6
// Related Topics 栈 数组 哈希表 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {

            int[][] d = new int[matrix.length][matrix[0].length];
            int[] area = new int[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    d[i][j] = matrix[i][j] == '0' ? 0 : j == 0 ? 1 : d[i][j - 1] + 1;
                    int minWidth = d[i][j];
                    int maxArea = minWidth;
                    for (int k = i - 1; k >= 0; k--) {
                        minWidth = Math.min(minWidth, d[k][j]);
                        maxArea = Math.max(maxArea, minWidth * (i - k));
                    }
                    area[j] = maxArea;
                }
            }

            for (int i = 0; i < matrix.length; i++) {

            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
