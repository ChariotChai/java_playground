package leetcode.hot;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc301 {
    //删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
//
// 说明: 输入可能包含了除 ( 和 ) 以外的字符。
//
// 示例 1:
//
// 输入: "()())()"
//输出: ["()()()", "(())()"]
//
//
// 示例 2:
//
// 输入: "(a)())()"
//输出: ["(a)()()", "(a())()"]
//
//
// 示例 3:
//
// 输入: ")("
//输出: [""]
// Related Topics 深度优先搜索 广度优先搜索


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> ans = new ArrayList<>();
            if (s.length() == 0) {
                ans.add("");
                return ans;
            }
            if (valid(s)) {
                ans.add(s);
                return ans;
            }

            Set<String> todo = new HashSet<>();
            todo.add(s);

            boolean notFound = true;
            while (!todo.isEmpty() && notFound) {
                Set<String> tmp = new HashSet<>();
                for (String ss : todo) {
                    if (ss.length() == 1) {
                        if (!ss.equals("(") && !ss.equals(")")) {
                            tmp.add(ss);
                            notFound = false;
                        }
                    } else {
                        for (int i = 0; i < ss.length(); i++) {
                            String s1 = ss.substring(0, i) + ss.substring(i + 1);
                            if (tmp.add(s1) && valid(s1)) {
                                notFound = false;
                            }
                        }
                    }
                }
                todo = tmp;
            }

            if (todo.isEmpty()) {
                ans.add("");
                return ans;
            }

            for (String ss : todo) {
                if (valid(ss)) {
                    ans.add(ss);
                }
            }
            return ans;
        }

        private boolean valid(String s) {
            int leftCnt = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    leftCnt++;
                } else if (c == ')') {
                    if (--leftCnt < 0) {
                        return false;
                    }
                }
            }
            return leftCnt == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Lc301().new Solution().removeInvalidParentheses("()())()")));
        System.out.println(JSON.toJSONString(new Lc301().new Solution().removeInvalidParentheses("(a)())()")));
        System.out.println(JSON.toJSONString(new Lc301().new Solution().removeInvalidParentheses(")(")));
        System.out.println(JSON.toJSONString(new Lc301().new Solution().removeInvalidParentheses("n")));
        System.out.println(JSON.toJSONString(new Lc301().new Solution().removeInvalidParentheses("")));
    }
}
