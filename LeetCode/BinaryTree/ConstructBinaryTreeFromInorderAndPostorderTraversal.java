package BinaryTree;

// 64 https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int postLength = postorder.length, inLength = inorder.length;
        if (postLength != inLength) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLength; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postLength - 1, map, 0, inLength - 1);
    }

    public TreeNode buildTree(int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int pivotIndex = map.get(rootVal); // 找到根节点在中序遍历中的位置
        root.left = buildTree(postorder, postStart, pivotIndex - inStart + postStart - 1, map, inStart, pivotIndex - 1);
        root.right = buildTree(postorder, pivotIndex - inStart + postStart, postEnd - 1, map, pivotIndex + 1, inEnd);
        return root;
    }
}
