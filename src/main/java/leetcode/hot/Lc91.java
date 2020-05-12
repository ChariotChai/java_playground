package leetcode.hot;

public class Lc91 {
    //一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
// 示例 1:
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2:
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
// Related Topics 字符串 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            int a = 0, b = 0;

            char[] cs = s.toCharArray();
            if (cs.length == 0) {
                return 0;
            }
            if (can1(cs[0])) {
                a = 1;
            }

            int aa, bb;
            for (int i = 1; i < cs.length; i++) {
                aa = a;
                bb = b;
                a = can1(cs[i]) ? aa + bb : 0;
                b = can2(cs[i - 1], cs[i]) ? aa : 0;
            }

            return a + b;
        }

        private boolean can1(char c) {
            return c != '0';
        }

        private boolean can2(char c1, char c2) {
            return c1 == '1' && '0' <= c2 && c2 <= '9' || c1 == '2' && '0' <= c2 && c2 <= '6';
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc91().new Solution().numDecodings("12"));
        System.out.println(new Lc91().new Solution().numDecodings("226"));
    }

}
