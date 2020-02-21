package bst;

public class DFS {
    static void dfsTraversal(TreeNode node) {
        if (node == null) return;
        System.out.println(node.getData());

        dfsTraversal(node.getLeft());
        dfsTraversal(node.getRight());
    }
}
