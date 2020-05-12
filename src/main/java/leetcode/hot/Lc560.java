package leetcode.hot;

import java.util.HashMap;
import java.util.Map;

public class Lc560 {
    //给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
// 示例 1 :
//
//
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
//
//
// 说明 :
//
//
// 数组的长度为 [1, 20,000]。
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
//
// Related Topics 数组 哈希表


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> sumCnt = new HashMap<>();
            sumCnt.put(0, 1);
            int ans = 0, sum = 0;
            for (int n : nums) {
                sum += n;
                ans += sumCnt.getOrDefault(sum - k, 0);
                int cnt = sumCnt.getOrDefault(sum, 0) + 1;
                sumCnt.put(sum, cnt);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc560().new Solution().subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(new Lc560().new Solution().subarraySum(new int[]{1, 2, 3}, 3));
    }

}
