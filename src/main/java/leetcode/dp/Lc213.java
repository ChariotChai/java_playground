package leetcode.dp;

public class Lc213 {

    //你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
//
// 示例 1:
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//
//
// 示例 2:
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。
// Related Topics 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            //rob 0
            int s1 = nums[0];
            int t1 = 0;
            int tt1, ss1;

            //don't rob 0
            int s2 = 0;
            int t2 = 0;
            int tt2, ss2;

            for (int i = 1; i < nums.length; i++) {
                if (i != nums.length - 1) {
                    tt1 = t1;
                    ss1 = s1;
                    s1 = tt1 + nums[i];
                    t1 = Math.max(ss1, tt1);
                }

                tt2 = t2;
                ss2 = s2;
                s2 = tt2 + nums[i];
                t2 = Math.max(ss2, tt2);
            }

            return Math.max(Math.max(s1, t1), Math.max(s2, t2));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc213().new Solution().rob(new int[]{1, 2}));
        System.out.println(new Lc213().new Solution().rob(new int[]{2, 3, 2}));
        System.out.println(new Lc213().new Solution().rob(new int[]{1, 2, 3, 1}));
    }

}
