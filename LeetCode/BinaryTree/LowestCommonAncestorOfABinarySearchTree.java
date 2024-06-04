package BinaryTree;

// 73 https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int min = Math.min(p.val, q.val), max = Math.max(p.val, q.val);
        // root值小于p和q中最小的值，则root的右子树中一定包含p和q的最近公共祖先
        if (root.val < min) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // root值大于p和q中最大的值，则root的左子树中一定包含p和q的最近公共祖先
        if (root.val > max) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // root值在p的值和q的值之间，则root即为p和q的最近公共祖先
        return root;
    }
}
