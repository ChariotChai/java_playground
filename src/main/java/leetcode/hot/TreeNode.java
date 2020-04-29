package leetcode.hot;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static TreeNode buildTree(Integer[] params) {
        return build(params, 0);
    }

    private static TreeNode build(Integer[] params, int nodeIdx) {
        if (nodeIdx >= params.length) {
            return null;
        }
        Integer val = params[nodeIdx];
        if (val == null) {
            return null;
        }
        TreeNode currNode = new TreeNode(val);
        currNode.left = build(params, (nodeIdx + 1) * 2 - 1);
        currNode.right = build(params, (nodeIdx + 1) * 2);
        return currNode;
    }
}
