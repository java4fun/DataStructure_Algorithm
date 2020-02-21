package bst;

public class TreeNode {
    private Integer data;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(Integer data) {
        this.data = data;
    }


    public TreeNode find(Integer data) {
        //Soft Delete, use this line
        // if (data == this.data && !isDeleted)

        //Otherwise

        if (data == this.data)
            return this;
        if (left != null && data < this.data)
            return left.find(data);
        if (right != null)
            return right.find(data);

        return null;
    }
    public void traverseInOrder() {
        if (this.left != null)
            this.left.traverseInOrder();
        System.out.print(this + " ");
        if (this.right != null)
            this.right.traverseInOrder();
    }

    // recursive
    public void insert(Integer data) {
        if (data >= this.data ) {
            if (this.right == null)
                this.right = new TreeNode(data);
            else
                this.right.insert(data);
        } else {
            if (this.left == null)
                this.left = new TreeNode(data);
            else
                this.left.insert(data);
        }

    }

    // iterative (Need fix issues)
    public void insertIterative(Integer target) {
        TreeNode ptr = this, prev=null;
        boolean left=false; // remember so we don't compare again
        while (ptr != null) {
            //if (target == ptr.data) throw new IllegalAccessException();   // we expect good data
            prev = ptr;
            if (target < ptr.data) { ptr = ptr.left; left = true;}
            else { ptr = ptr.right; left = false;}
        }
        TreeNode tmp = new TreeNode(target);
        //if (this == null) return tmp;
        if (left) prev.left = tmp;
        else prev.right = tmp;
        //return tmp;
    }

    public static TreeNode addSorted(int[] data, int start, int end) {
        if (end >= start) {
            int mid = (start+end)/2;
            TreeNode newNode = new TreeNode(data[mid]);
            newNode.left = addSorted(data, start, mid-1);
            newNode.right = addSorted(data, mid+1, end);
            return newNode;
        }
        return null;
    }

    public Integer smallest() {
        if (this.left == null)
            return this.data;
        return left.smallest();

    }

    public Integer largest() {
        if (this.right == null)
            return this.data;
        return right.largest();
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
    public int height() {
        if (isLeaf()) return 1;
        int left = 0;
        int right = 0;
        if (this.left != null)
            left = this.left.height();
        if (this.right != null)
            right = this.right.height();
        return (left > right) ? (left + 1) : (right + 1);
    }
    public int numOfLeafNodes() {
        if (isLeaf()) return 1;
        int leftLeaves = 0;
        int rightLeaves = 0;
        if (this.left != null)
            leftLeaves = left.numOfLeafNodes();
        if (this.right != null)
            rightLeaves = right.numOfLeafNodes();
        return leftLeaves + rightLeaves;
    }

    //soft delete ONLY
    private boolean isDeleted = false;
    public boolean isDeleted() {
        return isDeleted;
    }
    public void delete() {
        isDeleted = true;
    }


    public Integer getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}
