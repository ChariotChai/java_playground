package leetcode.hot;

public class Lc300 {
    //给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
// 示例:
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
// 说明:
//
//
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
// 你算法的时间复杂度应该为 O(n2) 。
//
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
// Related Topics 二分查找 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int res = 0;
            for (int num : nums) {
                int i = 0, j = res;
                while (i < j) {
                    int m = (i + j) / 2; // m == j only-if i == j
                    if (tails[m] < num) i = m + 1;
                    else j = m;
                }
                tails[i] = num;
                if (res == j) res++;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc300().new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new Lc300().new Solution().lengthOfLIS(new int[]{1, 2}));
        System.out.println(new Lc300().new Solution().lengthOfLIS(new int[]{1, 1}));
        System.out.println(new Lc300().new Solution().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

}
