package leetcode.hot;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

public class Lc84 {
    //给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
//
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
//
//
//
//
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
//
//
//
// 示例:
//
// 输入: [2,1,5,6,2,3]
//输出: 10
// Related Topics 栈 数组

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int largestRectangleArea(int[] heights) {
            if (heights.length == 0) {
                return 0;
            }
            int[] stack = new int[heights.length];
            int max = 0, p = -1;
            for (int i = 0; i <= heights.length; i++) {
                int h = i == heights.length ? -1 : heights[i];
                while (p >= 0 && heights[stack[p]] > h) {
                    int top = stack[p--];
                    int l = p < 0 ? -1 : stack[p];
                    max = Math.max(max, heights[top] * (i - 1 - l));
                }
                stack[++p] = i;
            }
            return max;
        }

        //单调栈
        public int largestRectangleAreaDetail(int[] heights) {

            int res = 0;

            //存 heights 的下标
            //栈底 -> 栈顶 对应的元素单调递增（单调递增栈）
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i <= heights.length; i++) {

                int currHeight = i < heights.length ? heights[i] : -1;

                //当前元素小于栈顶元素，则当前元素为栈顶元素之后的右边界
                //而栈中在栈顶之下的元素，为栈顶元素的左边界
                while (!stack.isEmpty() && heights[stack.peek()] > currHeight) {
                    //栈顶元素为 t；当前元素为 i；栈顶元素之下的元素为 k（栈中只有1个元素时k取-1）
                    //故元素t的高度为上界的矩形边界为[k+1,i-1]
                    int t = stack.pop();
                    int k = stack.isEmpty() ? -1 : stack.peek();
                    int area = heights[t] * (i - 1 - k);
                    res = Math.max(res, area);
                    System.out.println("k = " + k + " i = " + i + " j = " + heights[t]);
                }
                stack.push(i);
                System.out.println(JSON.toJSONString(stack));
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc84().new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new Lc84().new Solution().largestRectangleArea(new int[]{1, 9}));
        System.out.println(new Lc84().new Solution().largestRectangleArea(new int[]{3}));
        System.out.println(new Lc84().new Solution().largestRectangleArea(new int[]{0}));
        System.out.println(new Lc84().new Solution().largestRectangleArea(new int[]{}));
    }

}
