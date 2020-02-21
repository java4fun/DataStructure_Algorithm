package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedMap;

public class BFS {
    static void bfsTraversal (TreeNode node) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.offer(node);
        while (!q.isEmpty()) {
            node = q.poll();
            System.out.println(node.getData() + " ");
            if (node.getLeft() != null) q.offer(node.getLeft());
            if (node.getRight() != null) q.add(node.getRight());
        }
    }
}
