package leetcode.hot;

import java.util.concurrent.ThreadLocalRandom;

public class Lc215 {
    //在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1:
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
// 说明:
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
// Related Topics 堆 分治算法


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            int lo = 0, hi = len - 1;
            k--;
            while (lo <= hi) {
                int p = partition(nums, lo, hi); //[0,p) 区间前p个数 > nums[p]，故 nums[p]为第p+1大的数
                if (p < k) {
                    lo = p + 1;
                } else if (p > k) {
                    hi = p - 1;
                } else {
                    return nums[p];
                }
            }
            return -1;
        }

        private int partition(int[] nums, int lo, int hi) {
            if (hi > lo) {
                int r = lo + random.nextInt(hi - lo + 1);
                swap(nums, lo, r);
            }

            int base = nums[lo];
            int curr = lo;
            //确保[lo+1, curr]区间的值 > base
            for (int i = lo + 1; i <= hi; i++) {
                if (nums[i] > base) {
                    curr++;
                    swap(nums, i, curr);
                }
            }
            //[lo, curr)区间的值 > base
            swap(nums, lo, curr);
            return curr;
        }

        private void swap(int[] nums, int from, int to) {
            if (from == to) {
                return;
            }
            int t = nums[from];
            nums[from] = nums[to];
            nums[to] = t;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc215().new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new Lc215().new Solution().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

}
