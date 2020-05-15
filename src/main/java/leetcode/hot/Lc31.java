package leetcode.hot;

public class Lc31 {
    //实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须原地修改，只允许使用额外常数空间。
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
// Related Topics 数组


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            //找到最后一段降序序列，n[i-1] < n[i] > ...
            int split = nums.length - 1;
            while (split > 0 && nums[split] <= nums[split - 1]) {
                split--;
            }
            System.out.println("split = " + split);

            if (split > 0) {
                //找到[i,n)之内比n[i-1]大的最小的数，然后交换[i-1]和[k]，交换后[i,n)仍然是降序的
                int minGtIdx = nums.length - 1;
                while (nums[minGtIdx] <= nums[split - 1]) {
                    minGtIdx--;
                }
                System.out.println("minGtIdx = " + minGtIdx);
                swap(nums, split - 1, minGtIdx);
            }

            //对[i,n)升序排列，仅翻转即可
            for (int i = split, j = nums.length - 1; i < j; i++, j--) {
                swap(nums, i, j);
            }
        }

        private void swap(int[] arr, int from, int to) {
            if (from == to) {
                return;
            }
            int tmp = arr[from];
            arr[from] = arr[to];
            arr[to] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        new Lc31().new Solution().nextPermutation(new int[]{5, 4, 7, 5, 3, 2});
    }

}
