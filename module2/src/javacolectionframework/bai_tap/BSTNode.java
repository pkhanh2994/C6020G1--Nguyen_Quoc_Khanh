package javacolectionframework.bai_tap;

public class BSTNode {
    public class Node {
        int key;
        Node left;
        Node right;

        public Node(int item) {
            key = item;
            left = right = null;
        }

    }

    Node root;

    public BSTNode() {
        root = null;
    }

    void postOderRec(Node root) {
        if (root != null) {
            postOderRec(root.left);
            postOderRec(root.right);
            System.out.printf("%d ", root.key);
        }
    }

    // Phương thức gọi hàm sắp xếp
    void postOder() {
        postOderRec(root);
    }

    // hàm thực hiện việc sắp xếp và in ra cây nhị phân đã được sắp xếp
    public Node insertRec(Node root, int key) {
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
        root = insertRec(root, key);
    }

    Node searchKey(int key) {
        return search(root, key);
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
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
