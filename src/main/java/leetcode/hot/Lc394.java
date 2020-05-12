package leetcode.hot;

import java.util.Stack;

public class Lc394 {

    //给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
// 示例:
//
//
//s = "3[a]2[bc]", 返回 "aaabcbc".
//s = "3[a2[c]]", 返回 "accaccacc".
//s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
//
// Related Topics 栈 深度优先搜索


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            char[] cs = s.toCharArray();
            for (char c : cs) {
                if (c != ']') {
                    stack.push(c);
                    continue;
                }
                if (stack.isEmpty()) {
                    sb.append(c);
                    continue;
                }

                int repeat = 0;
                int digitCnt = 1;
                boolean flag = true;
                StringBuilder sbContent = new StringBuilder();
                while (flag) {



                    char cc = stack.pop();
                    if (cc >= 'a' && cc <= 'z') {
                        sbContent.append(cc);
                    } else if (cc >= '0' && cc <= '9') {
                        repeat += (cc - '0') * digitCnt;
                        digitCnt *= 10;
                    }
                }
                String ss = sbContent.reverse().toString();
                for (int i = 0; i < repeat; i++) {
                    sb.append(ss);
                }
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc394().new Solution().decodeString(""));
    }

}
