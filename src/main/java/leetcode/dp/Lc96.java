package leetcode.dp;

public class Lc96 {

    //给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
// 示例:
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// Related Topics 树 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            long ans = 1;
            for (int i = 1; i <= n; i++) {
                ans = (4 * i - 2) * ans / (i + 1);
            }
            return (int) ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        System.out.println(new Lc96().new Solution().numTrees(3));
        System.out.println(new Lc96().new Solution().numTrees(19));
    }

}
