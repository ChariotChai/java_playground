package leetcode.hot;

import com.alibaba.fastjson.JSON;

public class Lc72 {
    //给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
//
//
// 示例 1：
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2：
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
// Related Topics 字符串 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            char[] a = word1.toCharArray();
            char[] b = word2.toCharArray();

            if (word1.length() == 0 || word2.length() == 0) {
                return a.length + b.length;
            }

            int[] dp = new int[a.length + 1];
            for (int i = 0; i <= a.length; i++) {
                dp[i] = i;
            }

            for (int i = 1; i <= b.length; i++) {
                int b1 = dp[0], b2;
                dp[0] = i;
                for (int j = 1; j <= a.length; j++) {
                    b2 = dp[j];
                    dp[j] = Math.min(b1 + (a[j - 1] == b[i - 1] ? 0 : 1), Math.min(dp[j - 1], b2) + 1);
                    b1 = b2;
                }
            }

            return dp[a.length];
        }


        public int minDistance2(String word1, String word2) {
            char[] cs1 = word1.toCharArray();
            char[] cs2 = word2.toCharArray();
            int[][] dp = new int[cs2.length + 1][];

            dp[0] = new int[cs1.length + 1];
            for (int i = 0; i <= cs1.length; i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i <= cs2.length; i++) {
                dp[i] = new int[cs1.length + 1];
                dp[i][0] = i;
                for (int j = 1; j <= cs1.length; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + (cs1[j - 1] == cs2[i - 1] ? 0 : 1),
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }

            System.out.println(JSON.toJSONString(dp));
            return dp[cs2.length][cs1.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        //[[0,1,2,3,4,5],
        // [1,1,2,2,3,4],
        // [2,2,1,2,3,4],
        // [3,3,2,2,2,3]]
        System.out.println(new Lc72().new Solution().minDistance("horse", "ros"));
        System.out.println(new Lc72().new Solution().minDistance("", ""));
    }

}
