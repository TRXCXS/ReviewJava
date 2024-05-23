package BinaryTree;

// 39 https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
// 40 https://leetcode.cn/problems/binary-tree-inorder-traversal/
/**
 * 先序非递归和中序非递归的区别就是访问的时候不同
 * 1. 先序非递归是见到一个节点，只要不为空，就访问
 * 2. 中序非递归是获得栈顶节点之后再访问
 */
// 41 https://leetcode.cn/problems/binary-tree-postorder-traversal/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversalOfBinaryTree {
    public void preorderTraversalBinaryTree(List<Integer> list, TreeNode treeNode) {
        TreeNode p = treeNode;
        Stack<TreeNode> stack = new Stack<>();

        while (p != null || !stack.isEmpty()) {
            /**
             * 1. 如果当前节点不为空，访问当前节点，并把当前节点入栈，然后一路向左
             * 2. 如果当前节点为空，获取栈顶节点，然后向右走
             */

            if (p != null) {
                list.add(p.val);
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalBinaryTree(list, root);
        return list;
    }

    public void inorderTraversalBinaryTree(List<Integer> list, TreeNode treeNode) {
        TreeNode p = treeNode;
        Stack<TreeNode> stack = new Stack<>();

        while (p != null || !stack.isEmpty()) {
            /**
             * 1. 如果当前节点不为空，把当前节点入栈，然后一路向左
             * 2. 如果当前节点为空，获取栈顶节点，访问栈顶节点，然后向右走
             */
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalBinaryTree(list, root);
        return list;
    }

    public void postorderTraversalBinaryTree(List<Integer> list, TreeNode root) {
        /**
         * 使用currentNode来记录当前节点，visitedNode来记录上一个访问的节点
         * 1. 如果当前节点不为空，把当前节点入栈，然后一路向左
         * 2. 如果当前节点为空，获取当前节点为栈顶节点
         *
         * 3. 如果右节点存在且尚未被访问，则当前节点设置为右节点
         * 4. 右节点不存在或者右节点已经被访问，则可以访问当前节点
         * 5. 访问当前节点的步骤是：①访问当前节点，②当前节点设置visitedNode，③pop栈顶节点（即当前节点），④当前节点设置为null
         */
        TreeNode currentNode = root;
        TreeNode visitedNode = root;
        Stack<TreeNode> stack = new Stack<>();

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.peek();
            if (currentNode.right != null && currentNode.right != visitedNode) {
                currentNode = currentNode.right;
            } else {
                list.add(currentNode.val);
                visitedNode = currentNode;
                stack.pop();
                currentNode = null;
                /**
                 * 如果当前节点不设置为null
                 * 由于它指向的节点是存在的，那么会被入栈，之后会被重复访问
                 */
            }
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversalBinaryTree(list, root);
        return list;
    }
}
