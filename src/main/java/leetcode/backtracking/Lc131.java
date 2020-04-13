package leetcode.backtracking;

//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
// 返回 s 所有可能的分割方案。
//
// 示例:
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//]
// Related Topics 回溯算法


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc131 {

    class Solution {

        public List<List<String>> partition(String s) {
            List<List<String>> ans = new LinkedList<>();

            //dp[j][i], j <= i, 表示从字符串 s[j, i] 为回文串
            //s[j, i] 为回文串，则：s[j] == s[i]，且 s[j+1, i-1] 也为回文串（边界条件：长度<=1的串为回文串）
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                    }
                }
            }
            dfs(ans, new ArrayList<>(), dp, s, 0);
            return ans;
        }

        private void dfs(List<List<String>> ans, List<String> selected, boolean[][] dp, String s, int pos) {
            if (pos == s.length()) {
                ans.add(new ArrayList<>(selected));
                return;
            }
            for (int i = pos; i < s.length(); i++) {
                if (dp[pos][i]) {
                    selected.add(s.substring(pos, i + 1));
                    dfs(ans, selected, dp, s, i + 1);
                    selected.remove(selected.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Lc131().new Solution().partition("aab"));
    }

}
