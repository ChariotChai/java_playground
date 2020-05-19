package leetcode.hot;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Lc76 {

    //给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
//
// 示例：
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC"
//
// 说明：
//
//
// 如果 S 中不存这样的子串，则返回空字符串 ""。
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> charCnt = new HashMap<>();
            for (char c : t.toCharArray()) {
                charCnt.put(c, charCnt.getOrDefault(c, 0) - 1);
            }
            Queue<Integer> index = new LinkedList<>();
            char[] cs = s.toCharArray();
            int minStart = -1, minLen = -1;
            for (int i = 0; i < cs.length; i++) {
                char c = cs[i];
                if (!charCnt.containsKey(c)) {
                    continue;
                }

                index.add(i);
                charCnt.put(c, charCnt.get(c) + 1);

                if (charCnt.get(c) >= 0) {

                }

                while (!index.isEmpty()) {
                    if (charCnt.get(cs[index.peek()]) < 0) {
                        break;
                    }
                    int start = index.remove();
                    charCnt.put(cs[start], charCnt.get(cs[start]) - 1);
                    int len = i - start + 1;
                    if (minLen > len || minLen == -1) {
                        minLen = len;
                        minStart = start;
                        if (minLen == t.length()) {
                            break;
                        }
                    }
                }
            }
            if (minStart == -1) {
                return "";
            }
            return s.substring(minStart, minStart + minLen);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc76().new Solution().minWindow("ADOBECODEBANC", "ADOB"));
        System.out.println(new Lc76().new Solution().minWindow("ADOBECODEBANC", "ADOBV"));
        System.out.println(new Lc76().new Solution().minWindow("a", "a"));
    }

}
