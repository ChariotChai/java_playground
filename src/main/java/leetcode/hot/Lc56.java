package leetcode.hot;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

public class Lc56 {
    //给出一个区间的集合，请合并所有重叠的区间。
//
// 示例 1:
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
// Related Topics 排序 数组


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            quickSort(intervals, 0, intervals.length - 1);

            List<int[]> merged = new LinkedList<>();
            merged.add(intervals[0]);
            int[] lastInterval = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                int[] currInterval = intervals[i];
                if (currInterval[0] <= lastInterval[1]) {
                    lastInterval[1] = Math.max(lastInterval[1], currInterval[1]);
                } else {
                    lastInterval = currInterval;
                    merged.add(currInterval);
                }
            }

            int[][] ans = new int[merged.size()][];
            for (int i = 0; i < merged.size(); i++) {
                ans[i] = merged.get(i);
            }
            return ans;
        }

        private void quickSort(int[][] intervals, int lo, int hi) {
            if (lo > hi) {
                return;
            }
            int ref = intervals[lo][0];
            int pivot = lo;
            for (int i = lo + 1; i <= hi; i++) {
                if (intervals[i][0] > ref) {
                    continue;
                }
                pivot++;
                swap(intervals, pivot, i);
            }
            swap(intervals, lo, pivot);
            quickSort(intervals, lo, pivot - 1);
            quickSort(intervals, pivot + 1, hi);
        }

        private void swap(int[][] intervals, int from, int to) {
            if (from == to) {
                return;
            }
            int[] tmp = intervals[from];
            intervals[from] = intervals[to];
            intervals[to] = tmp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Lc56().new Solution().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(JSON.toJSONString(new Lc56().new Solution().merge(new int[][]{{1, 4}, {5, 6}})));
    }
}

