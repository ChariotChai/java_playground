package leetcode.hot;

public class Lc312 {

    //有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
//
// 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的
//left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
//
// 求所能获得硬币的最大数量。
//
// 说明:
//
//
// 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
//
//
// 示例:
//
// 输入: [3,1,5,8]
//输出: 167
//解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
//
// Related Topics 分治算法 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] nums) {
            int[] arr = new int[nums.length + 2];
            System.arraycopy(nums, 0, arr, 1, nums.length);
            arr[0] = 1;
            arr[arr.length - 1] = 1;

            //d[i][j] ：保留 i 和 j 的情况下的解
            //记 k in (i, j)，表示在求解 d[i][j] 时最后一个戳破的气球，这时问题的划分可以不重复无遗漏
            //最后戳破 k，可以先认为是保留 k，待 d[i][k] 与 d[k][j] 求解完毕后，只剩下 i,k,j，此时戳破 k 增加 n[i]*n[k]*n[j] 个
            //因此有状态转移方程：d[i][j] = max(d[i][k] + d[k][j] + n[i]*n[k]*n[j]), k in (i, j)
            //边界条件为，d[i][i+1] = 0，即相邻的两个为边界时，不存在方案

            //这里在判断迭代顺序的时候，画了一个坐标图，发现应该从 y = x 开始，沿着垂线的方向向左上方迭代
            //故迭代的参量为 dyx 即 y-x 的值，从0到n；内层迭代参量为 y 的值，从dyx到n；

            int[][] d = new int[arr.length][arr.length];
            for (int dyx = 0; dyx < arr.length; dyx++) {
                for (int y = dyx; y < arr.length; y++) {
                    int x = y - dyx;
                    int max = 0;
                    for (int k = x + 1; k < y; k++) {
                        max = Math.max(max, d[x][k] + d[k][y] + arr[x] * arr[k] * arr[y]);
                    }
                    d[x][y] = max;
                }
            }

            return d[0][arr.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc312().new Solution().maxCoins(new int[]{3, 1, 5, 8}));
    }

}
