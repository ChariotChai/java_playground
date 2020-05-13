package leetcode.hot;

import java.util.*;

public class Lc49 {

    //给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> m = new HashMap();

            for (String str : strs) {
                char[] sc = str.toCharArray();
                Arrays.sort(sc);
                String s = new String(sc);
                if (m.containsKey(s)) {
                    m.get(s).add(str);
                } else {
                    List<String> l = new LinkedList<>();
                    l.add(str);
                    m.put(s, l);
                }
            }

            List<List<String>> ans = new ArrayList<>(m.values());
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
