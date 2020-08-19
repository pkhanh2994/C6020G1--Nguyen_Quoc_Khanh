package javacolectionframework.bai_tap;

public class MainBST {
    public static void main(String[] args) {
        BSTNode tree = new BSTNode();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println("Postorder traversal of the given tree");
        tree.postOder();
        System.out.println();
        System.out.println("Preoder traversal of the given tree");
        tree.preOder();
        System.out.println();
        tree.deleteKey(50);
        System.out.println("The BST after deleted");
        tree.postOder();
        System.out.println();
        BSTNode.Node temp=tree.searchKey(100);
        if(temp!=null){
            System.out.println("The key was found");
        }else
            System.out.println("The key was not found");
    }
}
