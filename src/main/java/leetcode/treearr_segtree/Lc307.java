package leetcode.treearr_segtree;

import com.alibaba.fastjson.JSON;

public class Lc307 {

    //给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
//
// update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
//
// 示例:
//
// Given nums = [1, 3, 5]
//
//sumRange(0, 2) -> 9
//update(1, 2)
//sumRange(0, 2) -> 8
//
//
// 说明:
//
//
// 数组仅可以在 update 函数下进行修改。
// 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
//
// Related Topics 树状数组 线段树


    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        private int[] c;

        private int lowbit(int x) {
            //x的二进制中末尾连续0的个数
            //x以2为底的多项式分解中，最低次幂的系数
            //利用了计算机补码的特性 -x 的补码为 x取反后+1
            return x & (-x);
        }

        //这个操作表示将号位的值 +val，相应地，该节点的"父节点"都需要增加该值
        private void doUpdate(int i, int val) {
            while (i < this.c.length) {
                this.c[i] += val;
                i += lowbit(i);
            }
        }

        //获取原数组[0, i]区间和，
        private int doSum(int i) {
            int ans = 0;
            while (i > 0) {
                ans += this.c[i];
                i -= lowbit(i);
            }
            return ans;
        }

        public NumArray(int[] nums) {
            //通常的树状数组下标从1开始（为了方便lowbit的计算），故建立树状数组时可往后错一位，空出0号位
            int n = nums.length + 1;
            this.c = new int[n];
            for (int i = 1; i < n; i++) {
                doUpdate(i, nums[i - 1]);
            }
        }

        public void update(int i, int val) {
            val = val - sumRange(i, i);
            doUpdate(i + 1, val);
        }

        private int sum(int i) {
            return doSum(i + 1);
        }

        public int sumRange(int i, int j) {
            return sum(j) - sum(i - 1);
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(i,val);
     * int param_2 = obj.sumRange(i,j);
     */
//leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5};
        NumArray na = new Lc307().new NumArray(arr);
        System.out.println(JSON.toJSONString(na.c));
        System.out.println(na.sumRange(0, 2));
        na.update(1, 2);
        System.out.println(JSON.toJSONString(na.c));
        System.out.println(na.sumRange(0, 2));
    }


}
