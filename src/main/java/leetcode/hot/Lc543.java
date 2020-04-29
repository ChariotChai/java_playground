package leetcode.hot;

public class Lc543 {

    //给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
//
//
// 示例 :
//给定二叉树
//
//           1
//         / \
//        2   3
//       / \
//      4   5
//
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            return dfs(root)[0];
        }

        private int[] dfs(TreeNode root) {
            int[] ans = new int[2]; //ans[0] = root的子树直径，ans[1] = root的高度
            if (root == null) {
                return ans;
            }
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            ans[0] = Math.max(Math.max(left[0], right[0]), left[1] + right[1]);
            ans[1] = Math.max(left[1], right[1]) + 1;
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
