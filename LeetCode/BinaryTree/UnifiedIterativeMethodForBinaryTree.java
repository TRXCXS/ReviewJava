package BinaryTree;

// 42 https://leetcode.cn/problems/binary-tree-preorder-traversal/
// 43 https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
// 44 https://leetcode.cn/problems/binary-tree-postorder-traversal/description/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UnifiedIterativeMethodForBinaryTree {
    public void preorderTraversalBinaryTree(List<Integer> list, TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();

        if (treeNode != null) {
            stack.push(treeNode);
        }
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp != null) {
                stack.pop();

                /**
                 * 注意栈是先进后出的，先序遍历希望中左右，所以入栈顺序是右左中
                 */
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                }
                stack.push(temp);
                stack.push(null);
            } else {
                // 处理当前节点
                stack.pop();
                list.add(stack.pop().val);
            }
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalBinaryTree(list, root);
        return list;
    }

    public void inorderTraversalBinaryTree(List<Integer> list, TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();

        if (treeNode != null) {
            stack.push(treeNode);
        }
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp != null) {
                stack.pop();

                /**
                 * 注意栈是先进后出的，中序遍历希望左中右，所以入栈顺序是右中左
                 */
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                stack.push(temp);
                stack.push(null);
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            } else {
                // 处理当前节点
                stack.pop();
                list.add(stack.pop().val);
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalBinaryTree(list, root);
        return list;
    }

    public void postorderTraversalBinaryTree(List<Integer> list, TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();

        if (treeNode != null) {
            stack.push(treeNode);
        }
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp != null) {
                stack.pop();

                /**
                 * 注意栈是先进后出的，后序遍历希望左右中，所以入栈顺序是中右左
                 */
                stack.push(temp);
                stack.push(null);
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            } else {
                // 处理当前节点
                stack.pop();
                list.add(stack.pop().val);
            }
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversalBinaryTree(list, root);
        return list;
    }
}
