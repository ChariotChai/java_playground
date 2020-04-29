package leetcode.hot;

public class Lc581 {
    //给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
// 你找到的子数组应是最短的，请输出它的长度。
//
// 示例 1:
//
//
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
//
//
// 说明 :
//
//
// 输入的数组长度范围在 [1, 10,000]。
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。
//
// Related Topics 数组


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            boolean flagBefore = false, flagAfter = false;
            Integer min = null, max = null;

            for (int i = 1; i < n; i++) {
                if (nums[i] < nums[i - 1] && !flagBefore) {
                    flagBefore = true;
                    min = nums[i];
                }
                if (flagBefore && min > nums[i]) {
                    min = nums[i];
                }
                if (nums[n - 1 - i] > nums[n - i] && !flagAfter) {
                    flagAfter = true;
                    max = nums[n - 1 - i];
                }
                if (flagAfter && nums[n - 1 - i] > max) {
                    max = nums[n - 1 - i];
                }
            }

            if (min == null || max == null) {
                return 0;
            }

            int pre = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] > min) {
                    pre = i;
                    break;
                }
            }

            int after = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] < max) {
                    after = i;
                    break;
                }
            }
            return after > pre ? after - pre + 1 : 0;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        System.out.println(new Lc581().new Solution().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(new Lc581().new Solution().findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(new Lc581().new Solution().findUnsortedSubarray(new int[]{1}));
        System.out.println(new Lc581().new Solution().findUnsortedSubarray(new int[]{1, 3, 2, 2, 2}));
    }

}
