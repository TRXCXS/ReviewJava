package BinaryTree;

// 76 https://leetcode.cn/problems/trim-a-binary-search-tree/description/

public class TrimABinarySearchTree {
    public TreeNode trimBST1(TreeNode root, int low, int high) {
        trim(root, low, high);
        return root;
    }

    public void trim(TreeNode root, int low, int high) {
        if (root == null) return;

        if (root.val >= low && root.val <= high) {
            trim(root.left, low, high);
            trim(root.right, low, high);
        } else {
            if (root.left == null) {
                root = root.right;
                trim(root, low, high);
                return;
            }
            if (root.right == null) {
                root = root.left;
                trim(root, low, high);
                return;
            }
            TreeNode rightMinNode = root.right;
            while (rightMinNode.left != null) {
                rightMinNode = rightMinNode.left;
            }
            rightMinNode.left = root.left;
            root = root.right;
            trim(root, low, high);
        }
    }

    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val >= low && root.val <= high) {
            root.left = trimBST2(root.left, low, high);
            root.right = trimBST2(root.right, low, high);
        } else {
            if (root.left == null) {
                root = root.right;
                return trimBST2(root, low, high);
            }
            if (root.right == null) {
                root = root.left;
                return trimBST2(root, low, high);
            }
            TreeNode rightMinNode = root.right;
            while (rightMinNode.left != null) {
                rightMinNode = rightMinNode.left;
            }
            rightMinNode.left = root.left;
            root = root.right;
            return trimBST2(root, low, high);
        }
        return root;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        // 如果当前节点的值小于最小值，则说明该节点及其左子树都不符合要求，直接返回右子树
        // 注意此处返回的是对右子树修剪的结果，即此时的root是被“修剪”掉了
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // 同理，如果当前节点的值大于最大值，则说明该节点及其右子树都不符合要求，直接返回左子树
        // 通过直接返回对左子树修剪的结果，来实现“修剪”root的效果
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // 如果当前节点的值在[low, high]之间，则递归地对左右子树进行修剪
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
