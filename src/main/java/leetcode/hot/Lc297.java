package leetcode.hot;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc297 {
    //序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。
//
// 示例:
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]"
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
// Related Topics 树 设计


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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            Queue<TreeNode> queue = new LinkedList<>();
            List<String> arr = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    TreeNode node = queue.remove();
                    if (node == null) {
                        arr.add("null");
                    } else {
                        arr.add(String.valueOf(node.val));
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                }
            }

            return String.join(",", arr);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) {
                return null;
            }
            String[] ss = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int index = 1;
            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    TreeNode node = queue.remove();
                    if (node == null) {
                        continue;
                    }
                    String sl = ss[index++];
                    if (!sl.equals("null")) {
                        TreeNode l = new TreeNode();
                        l.val = Integer.parseInt(sl);
                        node.left = l;
                        queue.add(l);
                    }
                    String rl = ss[index++];
                    if (!rl.equals("null")) {
                        TreeNode r = new TreeNode();
                        r.val = Integer.parseInt(rl);
                        node.right = r;
                        queue.add(r);
                    }
                }
            }

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        TreeNode root = new Lc297().new Codec().deserialize("1,2,3,6,null,4,5,null,null,null,null,null,null");
        System.out.println(new Lc297().new Codec().serialize(root));
    }

}
