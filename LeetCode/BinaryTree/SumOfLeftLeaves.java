package BinaryTree;

// 60 https://leetcode.cn/problems/sum-of-left-leaves/description/

import java.util.ArrayList;
import java.util.List;

public class SumOfLeftLeaves {
    public boolean isLeaf(TreeNode root) {
        if (root == null) {
            return false;
        }
        return root.left == null && root.right == null;
    }

    public void getSumOfLeftLeaves(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (isLeaf(root.left)) {
                list.add(root.left.val);
            }
            if (root.left != null) {
                getSumOfLeftLeaves(root.left, list);
            }
            if (root.right != null) {
                getSumOfLeftLeaves(root.right, list);
            }
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getSumOfLeftLeaves(root, list);
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    public int sumOfLeftLeaves_New(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子树是叶子，返回左叶子值和右子树值
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves_New(root.right);
        }
        // 左子树不是叶子，对左右子树递归调用
        return sumOfLeftLeaves_New(root.left) + sumOfLeftLeaves_New(root.right);
    }
}
