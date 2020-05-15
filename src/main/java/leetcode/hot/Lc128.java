package leetcode.hot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lc128 {
    //给定一个未排序的整数数组，找出最长连续序列的长度。
//
// 要求算法的时间复杂度为 O(n)。
//
// 示例:
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
// Related Topics 并查集 数组


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        private int findRoot(int[] parent, int i) {
            if (parent[i] == -1) {
                return i;
            }
            return parent[i] = findRoot(parent, parent[i]);
        }

        private void merge(int[] parent, int i, int j, int[] memberCnt) {
            i = findRoot(parent, i);
            j = findRoot(parent, j);
            if (memberCnt[i] >= memberCnt[j]) {
                parent[j] = i;
                memberCnt[i] += memberCnt[j];
            } else {
                parent[i] = j;
                memberCnt[j] += memberCnt[i];
            }
        }

        public int longestConsecutive(int[] nums) {
            int[] memberCnt = new int[nums.length];
            Arrays.fill(memberCnt, 1);
            int[] parent = new int[nums.length];
            Arrays.fill(parent, -1);
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    continue;
                }
                map.put(nums[i], i);
                int lo = map.getOrDefault(nums[i] - 1, -1);
                int hi = map.getOrDefault(nums[i] + 1, -1);
                if (lo < 0 && hi >= 0) {
                    merge(parent, hi, i, memberCnt);
                } else if (lo >= 0 && hi < 0) {
                    merge(parent, lo, i, memberCnt);
                } else if (lo >= 0 && hi >= 0) {
                    merge(parent, lo, i, memberCnt);
                    merge(parent, lo, hi, memberCnt);
                }
            }

            int res = 0;
            for (int c : memberCnt) {
                res = Math.max(res, c);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc128().new Solution().longestConsecutive(new int[]{100, 101, 99, 98, 97, 96, 95, 94, 4, 200, 1, 3, 2, 5}));
        System.out.println(new Lc128().new Solution().longestConsecutive(new int[]{1, 2, 0, 1}));
    }

}
