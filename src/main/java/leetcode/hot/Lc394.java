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
            StringBuilder res = new StringBuilder(); //当前问题的解
            int multi = 0; //下一个嵌套串的重复次数
            Stack<Integer> stackInt = new Stack<>();
            Stack<String> stackStr = new Stack<>();
            for (Character c : s.toCharArray()) {
                //保留现场，开始处理嵌套串
                if (c == '[') {
                    stackInt.push(multi); //将要嵌套串的重复次数
                    stackStr.push(res.toString()); //暂存当前问题的解
                    //重置草稿纸
                    multi = 0;
                    res = new StringBuilder();
                }
                //结束嵌套串，还原父串现场
                else if (c == ']') {
                    int cur_multi = stackInt.pop(); //该嵌套串的重复次数
                    StringBuilder tmp = new StringBuilder();
                    for (int i = 0; i < cur_multi; i++) {
                        tmp.append(res);
                    }
                    //结束嵌套串后，返回父串并合并嵌套串
                    res = new StringBuilder(stackStr.pop()).append(tmp);
                } else if ('0' <= c && c <= '9') {
                    multi = multi * 10 + c - '0';
                } else {
                    res.append(c);
                }
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc394().new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Lc394().new Solution().decodeString("3[a2[c]]"));
        System.out.println(new Lc394().new Solution().decodeString("k2[a3[b4[c]d]e5[f]]g"));
    }

}
