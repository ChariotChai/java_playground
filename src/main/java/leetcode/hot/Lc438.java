package leetcode.hot;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Lc438 {
    //给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//
// 说明：
//
//
// 字母异位词指字母相同，但排列不同的字符串。
// 不考虑答案输出的顺序。
//
//
// 示例 1:
//
//
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
//
//
// 示例 2:
//
//
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
//
// Related Topics 哈希表


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            int len = p.length();
            if (s.length() < len) {
                return ans;
            }

            int[] pdict = new int[26];
            int dictPositiveSum = 0;
            for (char cp : p.toCharArray()) {
                pdict[cp - 'a'] += 1;
                dictPositiveSum += 1;
            }

            char[] cs = s.toCharArray();

            for (int i = 0; i < len; i++) {
                int index = cs[i] - 'a';
                if (pdict[index] > 0) {
                    dictPositiveSum--;
                }
                pdict[index]--;
            }
            if (dictPositiveSum == 0) {
                ans.add(0);
            }

            for (int i = len; i < cs.length; i++) {
                int idRemove = cs[i - len] - 'a';
                if (pdict[idRemove] >= 0) {
                    dictPositiveSum++;
                }
                pdict[idRemove]++;

                int idAdd = cs[i] - 'a';
                if (pdict[idAdd] > 0) {
                    dictPositiveSum--;
                }
                pdict[idAdd]--;

                if (0 == dictPositiveSum) {
                    ans.add(i - len + 1);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Lc438().new Solution().findAnagrams("cbaebabacd", "abc")));
        System.out.println(JSON.toJSONString(new Lc438().new Solution().findAnagrams("abab", "ab")));
        System.out.println(JSON.toJSONString(new Lc438().new Solution().findAnagrams("abab", "abbac")));
    }

}
