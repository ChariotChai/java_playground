package leetcode.dp;

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
            char[] ss = s.toCharArray();
            if (ss[0] == '0') {
                return 0;
            }
            int pre = 1, curr = 1;
            for (int i = 1; i < ss.length; i++) {
                int tmp = curr;

                if (ss[i] == '0') {
                    if (ss[i - 1] == '1' || ss[i - 1] == '2') {
                        curr = pre;
                    } else {
                        return 0;
                    }
                } else if (ss[i - 1] == '1' || (ss[i - 1] == '2' && ss[i] >= '1' && ss[i] <= '6')) {
                    curr = curr + pre;
                }

                pre = tmp;
            }
            return curr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
