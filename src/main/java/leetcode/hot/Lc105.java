package leetcode.hot;

import com.alibaba.fastjson.JSON;

public class Lc105 {
    //根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组


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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
            if (preend < prestart) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[prestart]);

            int i = instart;
            while (i < inend) {
                if (preorder[prestart] == inorder[i]) {
                    break;
                }
                i++;
            }

            root.left = build(preorder, prestart + 1, prestart + i - instart,
                    inorder, instart, i - 1);
            root.right = build(preorder, prestart + i - instart + 1, preend,
                    inorder, i + 1, inend);
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        TreeNode root = new Lc105().new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(JSON.toJSONString(root));
    }

}
