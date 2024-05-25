package BinaryTree.FillTheNextRightNodePointerForEachNode;

// 51 https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FillTheNextRightNodePointerForEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        int levelSize = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            List<Node> list = new ArrayList<>();
            while (list.size() < levelSize) {
                Node temp = queue.remove();
                if (temp != null) {
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                    list.add(temp);
                }
            }
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
        }

        return root;
    }
}
