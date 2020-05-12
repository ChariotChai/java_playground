package leetcode.hot;

public class Lc416 {

    //给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 注意:
//
//
// 每个数组中的元素不会超过 100
// 数组的大小不会超过 200
//
//
// 示例 1:
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
//
//
//
//
// 示例 2:
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
//
//
//
// Related Topics 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            int max = 0;
            for (int n : nums) {
                sum += n;
                max = Math.max(max, n);
            }
            if ((sum & 1) != 0) {
                return false;
            }
            sum = sum / 2;
            if (max > sum) {
                return false;
            }

            boolean[] dp = new boolean[sum + 1];
            dp[nums[0]] = true;

            int currSum = nums[0];
            int currMin = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int n = nums[i];
                currSum += n;
                currMin = Math.min(currMin, n);
                int lim = Math.min(currSum, sum);
                for (int j = lim; j >= currMin; j--) {
                    dp[j] = dp[j] || j >= n && dp[j - n];
                }
            }

            return dp[sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc416().new Solution().canPartition(new int[]{11, 5, 1, 5}));
        System.out.println(new Lc416().new Solution().canPartition(new int[]{1, 5, 2, 3}));
        System.out.println(new Lc416().new Solution().canPartition(new int[]{100}));
    }
}
