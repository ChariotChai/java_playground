package leetcode.hot;

public class Lc538 {

    //给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节
//点值之和。
//
//
//
// 例如：
//
// 输入: 原始二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
//
//
//
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同
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
    //注意是【搜索】树！left_tree < root < right_tree
    //问题等价于，每个节点的值+=该节点右子树节点值之和
    class Solution {
        private int sum = 0;

        public TreeNode convertBST(TreeNode root) {

            if (root == null) {
                return null;
            }

            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);

            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
