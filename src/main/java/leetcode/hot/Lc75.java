package leetcode.hot;

import com.alibaba.fastjson.JSON;

public class Lc75 {

    //给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
// 注意:
//不能使用代码库中的排序函数来解决这道题。
//
// 示例:
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2]
//
// 进阶：
//
//
// 一个直观的解决方案是使用计数排序的两趟扫描算法。
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
// 你能想出一个仅使用常数空间的一趟扫描算法吗？
//
// Related Topics 排序 数组 双指针


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int lo = -1, hi = nums.length;
            while (lo < nums.length - 1 && nums[lo + 1] == 0) {
                lo++;
            }
            while (hi > 1 && nums[hi - 1] == 2) {
                hi--;
            }
            int i = lo + 1;
            while (i < hi) {
                if (nums[i] == 0) {
                    lo++;
                    if (lo < i) {
                        swap(nums, lo, i);
                    }
                    i++;
                } else if (nums[i] == 2) {
                    hi--;
                    if (i < hi) {
                        swap(nums, hi, i);
                    }
                } else {
                    i++;
                }
            }
        }

        private void swap(int[] nums, int from, int to) {
            if (from == to) {
                return;
            }
            int tmp = nums[from];
            nums[from] = nums[to];
            nums[to] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
//        int[] input = new int[]{0};
//        int[] input = new int[]{0, 1, 0};
        int[] input = new int[]{2, 0, 2, 1, 1, 0};
        new Lc75().new Solution().sortColors(input);
        System.out.println(JSON.toJSONString(input));
    }

}
