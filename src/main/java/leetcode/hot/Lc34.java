package leetcode.hot;

public class Lc34 {

    //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 你的算法时间复杂度必须是 O(log n) 级别。
//
// 如果数组中不存在目标值，返回 [-1, -1]。
//
// 示例 1:
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//
// 示例 2:
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]
// Related Topics 数组 二分查找


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = new int[]{-1, -1};

            int lo = 0, hi = nums.length;
            int mi, val;
            while (lo < hi) {
                mi = (lo + hi) / 2;
                val = nums[mi];
                if (val >= target) {
                    hi = mi;
                } else {
                    lo = mi + 1;
                }
            }
            ans[0] = lo == nums.length || nums[lo] != target ? -1 : lo;

            lo = 0;
            hi = nums.length;
            while (lo < hi) {
                mi = (lo + hi) / 2;
                val = nums[mi];
                if (val <= target) {
                    lo = mi + 1;
                } else {
                    hi = mi;
                }
            }
            ans[1] = lo == 0 || nums[lo - 1] != target ? -1 : lo - 1;

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
