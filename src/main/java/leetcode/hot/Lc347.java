package leetcode.hot;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Lc347 {
    //给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//
//
// 示例 1:
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
// 输入: nums = [1], k = 1
//输出: [1]
//
//
//
// 提示：
//
//
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
// 你可以按任意顺序返回答案。
//
// Related Topics 堆 哈希表


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> m = new HashMap<>();
            for (int n : nums) {
                if (m.containsKey(n)) {
                    m.put(n, m.get(n) + 1);
                } else {
                    m.put(n, 1);
                }
            }

            class node implements Comparable<node> {
                int val;
                int cnt;

                @Override
                public int compareTo(node node) {
                    return node.cnt - this.cnt;
                }
            }

            PriorityQueue<node> heap = new PriorityQueue<>();
            for (Map.Entry<Integer, Integer> e : m.entrySet()) {
                node n = new node();
                n.val = e.getKey();
                n.cnt = e.getValue();
                heap.add(n);
            }

            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = heap.poll().val;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Lc347().new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

}
