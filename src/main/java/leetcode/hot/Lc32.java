package leetcode.hot;

public class Lc32 {

    //给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
// 示例 1:
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//
//
// 示例 2:
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
//
// Related Topics 字符串 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            char[] cs = s.toCharArray();
            if (cs.length == 0) {
                return 0;
            }
            int[] d = new int[cs.length];
            int max = 0;
            for (int i = 1; i < cs.length; i++) {
                if (cs[i] == '(') {
                    d[i] = 0;
                } else if (cs[i - 1] == '(') {
                    d[i] = i >= 2 ? d[i - 2] + 2 : 2;
                } else {
                    int pre = i - d[i - 1] - 1;
                    if (pre >= 0 && cs[pre] == '(') {
                        d[i] = d[i - 1] + (pre > 0 ? d[pre - 1] : 0) + 2;
                    }
                }
                max = Math.max(max, d[i]);
            }
            return max;
        }

        public int longestValidParentheses4(String s) {
            char[] cs = s.toCharArray();
            if (cs.length == 0) {
                return 0;
            }
            int left = 0, right = 0, max = 0;

            for (char c : cs) {
                if (c == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    max = Math.max(max, left + right);
                } else if (left < right) {
                    left = right = 0;
                }
            }

            left = right = 0;
            for (int i = cs.length - 1; i >= 0; i--) {
                if (cs[i] == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    max = Math.max(max, left + right);
                } else if (left > right) {
                    left = right = 0;
                }
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
//        System.out.println(new Lc32().new Solution().longestValidParentheses("(()"));
//        System.out.println(new Lc32().new Solution().longestValidParentheses(")()())"));
//        System.out.println(new Lc32().new Solution().longestValidParentheses("("));
//        System.out.println(new Lc32().new Solution().longestValidParentheses("()(()"));
//        System.out.println(new Lc32().new Solution().longestValidParentheses("(()()"));
        System.out.println(new Lc32().new Solution().longestValidParentheses("(()())"));
    }

}
