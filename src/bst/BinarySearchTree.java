package bst;

public class BinarySearchTree {
    private TreeNode root;

    public void insert (Integer data){
        if (root == null)
            root = new TreeNode(data);
        else
            root.insert(data);
    }

    public Integer smallest() {
        if (this.root != null)
            return this.root.smallest();
        return null;
    }

    public Integer largest() {
        if (this.root != null)
            return this.root.largest();
        return null;
    }
    public int height() {
        if (this.root == null) return 0;
        return this.root.height();
    }

    public TreeNode find(Integer data) {
        if (root != null)
            return root.find(data);
        return null;
    }

    // Soft delete
    public void softDelete(Integer data) {
        find(data).delete();
    }

        // iterative implementaion
    public void delete(Integer data) {
        TreeNode parent = this.root;
        TreeNode current = this.root;
        boolean isLeftChild = false;

        if (current == null)
            return;  // tree is empty

        while (current != null && current.getData() != data) {
            parent = current;

            if (data < current.getData()) {
                current = current.getLeft();
                isLeftChild = true;
            } else {
                current = current.getRight();
                isLeftChild = false;
            }
        }

        if (current == null) return;   // node to be deleted not found

        // case 1: leaf node
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null; // no elements in tree now
            } else {
                if (isLeftChild)
                    parent.setLeft(null);
                else
                    parent.setRight(null);
            }

        }
        // case 2: broken down further into 2 separate cases
        else if (current.getRight() == null) {// current has left child
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {// current has right child
            if (current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        }
        // case 3 - Most complicated (node to be deleted has 2 children)
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }
    }
    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parentOfSuccessor = node;
        TreeNode successor = node;
        TreeNode current = node.getRight();
        while (current != null) {
            parentOfSuccessor = successor;
            successor = current;
            current = current.getLeft();
        }
        if (successor != node.getRight()) {
            parentOfSuccessor.setLeft(successor.getRight());
            successor.setRight(node.getRight());
        }
        return successor;
    }

    public void traverseInOrder() {
        if (this.root != null)
            this.root.traverseInOrder();
        System.out.println();
    }

    public int numOfLeafNodes() {
        if (this.root == null) return 0;
        return this.root.numOfLeafNodes();
    }

    public static BinarySearchTree createFromSortedArray(int[] data) {
        BinarySearchTree bst = new BinarySearchTree();
        if (data != null && data.length > 0) {
            bst.root = TreeNode.addSorted(data, 0, data.length-1);
        }
        return bst;
    }

    // for test
    public static void main(String[] args) {
//        BinarySearchTree bt = createBinarySearchTree();

        int[] sample = { 212, 580, 6, 7, 28, 84, 112, 434};
        BinarySearchTree bst = new BinarySearchTree();
        for (int x : sample) {
            bst.insert(x);
        }
        System.out.println(bst.find(65));
        System.out.println(bst.smallest());
        System.out.println(bst.largest());
//		bst.delete(84);
        System.out.println(bst.numOfLeafNodes());
        System.out.println(bst.height());
        bst.traverseInOrder();
    }

//    private static BinarySearchTree createBinarySearchTree() {
//        BinarySearchTree bt = new BinarySearchTree();
//
//        bt.insert(6);
//        bt.insert(4);
//        bt.insert(8);
//        bt.insert(3);
//        bt.insert(5);
//        bt.insert(7);
//        bt.insert(9);
//
//        return bt;
//    }
}
