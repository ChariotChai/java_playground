package leetcode.backtracking;

import java.util.*;


//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
// Related Topics 数组 回溯算法

public class Lc90 {

    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Map<Integer, Integer> m = new HashMap<>();
            for (int n : nums) {
                m.put(n, m.getOrDefault(n, 0) + 1);
            }

            List<List<Integer>> ans = new LinkedList<>();
            ans.add(new ArrayList<>());

            m.forEach((n, cnt) -> {
                int len = ans.size();
                for (int i = 0; i < len; i++) {
                    List<Integer> l = ans.remove(0);
                    for (int j = 0; j <= cnt; j++) {
                        List<Integer> t = new ArrayList<>(l);
                        for (int k = 0; k < j; k++) {
                            t.add(n);
                        }
                        ans.add(t);
                    }
                }
            });

            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Lc90().new Solution().subsetsWithDup(new int[]{1, 2, 2}));
    }

}
