package leetcode.dp;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

public class Lc95 {

    //给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
//
// 示例:
//
// 输入: 3
//输出:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释:
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
// Related Topics 树 动态规划


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */

    @Data
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            return generate(1, n);
        }

        public List<TreeNode> generate(int start, int end) {
            List<TreeNode> ans = new LinkedList<>();

            if (start > end) {
                ans.add(null);
                return ans;
            }

            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTrees = generate(start, i - 1);
                List<TreeNode> rightTrees = generate(i + 1, end);

                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        ans.add(root);
                    }
                }
            }

            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Lc95().new Solution().generateTrees(3)));
    }

}
