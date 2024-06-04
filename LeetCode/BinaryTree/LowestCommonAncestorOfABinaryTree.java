package BinaryTree;

// 72 https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 空树肯定返回null，因为其不存在p和q的最近公共祖先
        // 若p是根节点，q只能是其子孙节点，则二者的最近公共祖先就是p。反之亦然。
        if (root == null || root == p || root == q) {
            return root;
        }

        // 向左右子树递归
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // lowestCommonAncestor在寻找p和q的最近公共祖先
        // 如果left==null，表示在左子树中既没有找到p也没有找到q，则转而考虑right。反之亦然。
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // 如果left和right都不为空，则说明p和q分别存在于root的左右子树中，则root就是最近公共祖先。
        return root;
    }
}
