package leetcode.hot;

public class Lc287 {
    //给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。
//
// 示例 1:
//
// 输入: [1,3,4,2,2]
//输出: 2
//
//
// 示例 2:
//
// 输入: [3,1,3,4,2]
//输出: 3
//
//
// 说明：
//
//
// 不能更改原数组（假设数组是只读的）。
// 只能使用额外的 O(1) 的空间。
// 时间复杂度小于 O(n2) 。
// 数组中只有一个重复的数字，但它可能不止重复出现一次。
//
// Related Topics 数组 双指针 二分查找


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            int x = 0, y = 0;
            while (x != y || x == 0) {
                x = nums[x];
                y = nums[nums[y]];
            }
            int z = 0;
            while (z != y) {
                z = nums[z];
                y = nums[y];
            }
            return z;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc287().new Solution().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new Lc287().new Solution().findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(new Lc287().new Solution().findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
    }

}
