package BinaryTree;

// 65 https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length, inLength = inorder.length;
        if (preLength != inLength) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLength; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLength - 1, map, 0, inLength - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, HashMap<Integer, Integer> map, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int pivotIndex = map.get(rootVal); // 找到根节点在中序遍历中的位置
        root.left = buildTree(preorder, preStart + 1, pivotIndex - inStart + preStart, map, inStart, pivotIndex - 1);
        root.right = buildTree(preorder, pivotIndex - inStart + preStart + 1, preEnd, map, pivotIndex + 1, inEnd);
        return root;
    }
}
