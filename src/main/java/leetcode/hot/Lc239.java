package leetcode.hot;

import com.alibaba.fastjson.JSON;

import java.util.Deque;
import java.util.LinkedList;

public class Lc239 {
    //给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//
// 返回滑动窗口中的最大值。
//
//
//
// 进阶：
//
// 你能在线性时间复杂度内解决此题吗？
//
//
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] index = new int[k + 1];
            int start = 0, end = 0;
            int[] ans = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
//                if (start != end && index[start] + k <= i) {
//                    start = start == k ? 0 : start + 1;
//                }
//                while (start != end && nums[index[end == 0 ? k : end - 1]] <= nums[i]) {
//                    end = end == 0 ? k : end - 1;
//                }
//                index[end] = i;
//                end = end == k ? 0 : end + 1;
//                if (i >= k - 1) {
//                    ans[i - k + 1] = nums[index[start]];
//                }
                if (start != end && index[start] + k <= i) {
                    start = (start + 1) % (k + 1);
                }
                while (start != end && nums[index[(end + k) % (k + 1)]] <= nums[i]) {
                    end = (end + k) % (k + 1);
                }
                index[end] = i;
                end = (end + 1) % (k + 1);
                if (i >= k - 1) {
                    ans[i - k + 1] = nums[index[start]];
                }
            }
            return ans;
        }

        //单调队列（非增）
        public int[] maxSlidingWindow2(int[] nums, int k) {
            Deque<Integer> deq = new LinkedList<>();
            int[] ans = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                //维护窗口长度
                if (!deq.isEmpty() && deq.peekFirst() + k <= i) {
                    deq.pollFirst();
                }

                //维护队列非增关系
                while (!deq.isEmpty() && nums[deq.peekLast()] <= nums[i]) {
                    deq.pollLast();
                }

                deq.addLast(i);

                //队头元素为窗口最大值
                if (i >= k - 1) {
                    ans[i - k + 1] = nums[deq.peekFirst()];
                }
//                System.out.println(JSON.toJSONString(deq));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Lc239().new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(JSON.toJSONString(new Lc239().new Solution().maxSlidingWindow(new int[]{1, -1}, 1)));
        System.out.println(JSON.toJSONString(new Lc239().new Solution().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }

}
