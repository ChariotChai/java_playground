package leetcode.hot;

public class Lc647 {
    //给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
//
// 示例 1:
//
//
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
//
//
// 示例 2:
//
//
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
//
//
// 注意:
//
//
// 输入的字符串长度不会超过1000。
//
// Related Topics 字符串 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int len = s.length();
            char[] cs = new char[len * 2 + 1];
            char[] ss = s.toCharArray();
            for (int i = 0; i < len; i++) {
                cs[i * 2 + 1] = ss[i];
            }

            int[] radius = new int[cs.length];
            int maxCenter = 0;
            int maxRight = 0;
            int ans = 0;
            for (int i = 1; i < cs.length - 1; i++) {
                int mirror = 2 * maxCenter - i;
                int r = maxRight > i ? Math.min(maxRight - i, radius[mirror]) : 0;
                while (i - r > 0 && i + r < cs.length - 1 && cs[i + r + 1] == cs[i - r - 1]) {
                    r++;
                }
                radius[i] = r;
                if (r + i > maxRight) {
                    maxRight = r + i;
                    maxCenter = i;
                }
                ans += (r + 1) / 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        new Lc647().new Solution().countSubstrings("abbaa");
    }

}
