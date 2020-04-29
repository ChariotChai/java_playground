package leetcode.hot;

import com.alibaba.fastjson.JSON;

public class Lc283 {

    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            for (int firstZeroIdx = 0, current = 0; current < nums.length; current++) {
                if (nums[current] != 0) {
                    int t = nums[firstZeroIdx];
                    nums[firstZeroIdx] = nums[current];
                    nums[current] = t;
                    firstZeroIdx++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 3};
        new Lc283().new Solution().moveZeroes(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
