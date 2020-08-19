package javacolectionframework.bai_tap;

public class BSTNode {
    public class Node {
        int key;
        Node left;
        Node right;


        public Node(int item) {
            this.key = item;
            this.left = this.right = null;
        }

    }

    Node root;

    public BSTNode() {
        this.root = null;
    }

    private void postOderRec(Node root) {
        if (root != null) {
            postOderRec(root.left);
            postOderRec(root.right);
            System.out.printf("%d ", root.key);
        }
    }

    private void preOderRec(Node root) {
        if (root != null) {
            System.out.printf("%d ", root.key);
            preOderRec(root.left);
            preOderRec(root.right);
        }
    }

    // Phương thức gọi hàm sắp xếp
    public void postOder() {
        postOderRec(this.root);
    }

    public void preOder() {
        preOderRec(this.root);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    void insert(int key) {
        this.root = insertRec(this.root, key);
    }

    Node searchKey(int key) {
        return search(this.root, key);
    }

    void deleteKey(int key) {
        this.root = deleteRec(this.root, key);
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
            // nếu key có cùng giá trị với node key thì chính là node cần xóa
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node có 2 node con.
            root.key = minValue(root.right);

            // Xóa phần từ nhỏ nhất bên phải
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    private Node search(Node root, int key) {

        if (root == null || root.key == key)
            return root;

        if (key > root.key) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }

    }
}
