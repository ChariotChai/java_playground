package leetcode.hot;

import java.util.Stack;

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
            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }

            int max = 0;
            int[] d = new int[matrix[0].length];
            int[] index = new int[d.length];

            for (char[] row : matrix) {
                int p = -1;
                for (int x = 0; x <= d.length; x++) {
                    if (x < d.length) {
                        d[x] = row[x] == '0' ? 0 : d[x] + 1;
                    }
                    int height = x == d.length ? -1 : d[x];
                    while (p != -1 && d[index[p]] > height) {
                        int top = index[p--];
                        int left = p == -1 ? -1 : index[p];
                        max = Math.max(max, d[top] * (x - 1 - left));
                    }
                    index[++p] = x;
                }
            }

            return max;
        }

        public int maximalRectangle1(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }

            //按行遍历，遍历到第 y 行时，以 (x, y) 为底的柱的高度
            int[] d = new int[matrix[0].length];
            int max = 0;

            for (int y = 0; y < matrix.length; y++) {
                //计算当前行的柱状图
                for (int x = 0; x < matrix[0].length; x++) {
                    d[x] = matrix[y][x] == '0' ? 0 : d[x] + 1;
                }

                //利用单调栈，按84题方式求解以 (x, y) 为右下角的矩形面积
                Stack<Integer> index = new Stack<>(); //单调递减栈
                for (int x = 0; x <= d.length; x++) {
                    int height = x == matrix[0].length ? -1 : d[x];
                    while (!index.isEmpty() && d[index.peek()] <= height) {
                        int h = d[index.pop()];
                        int right = x - 1;
                        int left = index.isEmpty() ? 0 : index.peek() + 1;
                        int area = h * (right - left + 1);
                        max = Math.max(max, area);
                    }
                    index.push(x);
                }
            }

            return max;
        }

        public int maximalRectangle2(char[][] matrix) {

            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }

            //d[y][x] 为第y行以x为右界的连续1的个数
            int[][] d = new int[matrix.length][matrix[0].length];

            //ans[y][x] 为以(x,y)为右下角的矩形的面积
            int max = 0;

            for (int y = 0; y < matrix.length; y++) {
                for (int x = 0; x < matrix[0].length; x++) {
                    d[y][x] = matrix[y][x] == '0' ? 0 : (x == 0 ? 1 : d[y][x - 1] + 1);
                    int minWidth = d[y][x];
                    int maxArea = minWidth;
                    for (int k = y - 1; k >= 0; k--) {
                        minWidth = Math.min(minWidth, d[k][x]);
                        maxArea = Math.max(maxArea, minWidth * (y - k + 1));
                    }

                    max = Math.max(max, maxArea);
                }
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
//        char[][] matrix = new char[][]{
//                {'0'},
//        };
        System.out.println(new Lc85().new Solution().maximalRectangle(matrix));
    }

}
