package javacolectionframework.bai_tap;

public class Main {
    public static void main(String[] args) {
        BSTNode tree = new BSTNode();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println("Inorder traversal of the given tree");
        tree.postOder();
        tree.deleteKey(30);
        System.out.println("-----------");
        tree.postOder();
        BSTNode.Node temp=tree.searchKey(30);
        if(temp!=null){
            System.out.println("ok");
        }else
            System.out.println("not ok");
    }
}
