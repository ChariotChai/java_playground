package leetcode.hot;

public class Lc152 {
    //给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
//
//
//
// 示例 1:
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
// Related Topics 数组 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int a = 0, b = 0;
            if (nums[0] > 0) {
                a = nums[0];
            } else {
                b = nums[0];
            }
            int max = a;

            for (int i = 1; i < nums.length; i++) {
                int n = nums[i];
                int aa = a;
                int bb = b;
                if (n > 0) {
                    a = Math.max(aa * n, n);
                    b = bb * n;
                } else if (n < 0) {
                    a = bb * n;
                    b = Math.min(aa * n, n);
                } else {
                    a = 0;
                    b = 0;
                }

                if (a > max) {
                    max = a;
                }
            }
            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc152().new Solution().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new Lc152().new Solution().maxProduct(new int[]{-2, 0, -1}));
    }

}
