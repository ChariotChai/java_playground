package leetcode.hot;

public class Lc114 {
    //给定一个二叉树，原地将它展开为链表。
//
// 例如，给定二叉树
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6
//
// 将其展开为：
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        //左子树改为右子树
        //原右子树续接原左子树的最右
        //从新右子树的根节点迭代上述过程
        public void flatten(TreeNode root) {
            while (root != null) {
                if (root.left != null) {
                    TreeNode curr = root.left;
                    while (curr.right != null) {
                        curr = curr.right;
                    }
                    curr.right = root.right;
                    root.right = root.left;
                    root.left = null;
                }
                root = root.right;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
