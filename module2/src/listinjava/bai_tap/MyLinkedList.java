package listinjava.bai_tap;


public class MyLinkedList<E> {

    public MyLinkedList() {

    }

    public class Node {
        private Node next;
        private Object data;
        private int numNodes;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    private Node head;
    private int numNodes = 0;


    private void checkIndex(int index) {
        if (index < 0 || index > numNodes)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }


    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    // 10,20,30,40
    // node10.next = node20;
    // node20.next = node30;
    // node40 = new Node(40);
    // node30.next = node40
    public void addLast(E element) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public int size() {
        return this.numNodes;
    }


    public E remove(int index) {
        checkIndex(index);
        Node temp = head;
        Object data;
        if (index == 0) {
            data = temp.data;
            head = head.next;
            numNodes--;
        } else {

            for (int i = 1; i < index - 1 && temp != null; i++) {
                temp = temp.next;
            }
        }

        data = temp.next.data;
        temp.next = temp.next.next;
        numNodes--;
        return (E) data;

    }

    public boolean removeElement(E element) {
        if (head.data.equals(element)) {
            remove(0);
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.next.data.equals(element)) {
                    temp.next = temp.next.next;
                    return true;
                }

            }
        }
        return false;
    }

    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public MyLinkedList<E> clone() {
        if (numNodes == 0) {
            throw new IndexOutOfBoundsException("Linkdedlist is null");
        }
        MyLinkedList<E> returnMylinkedList = new MyLinkedList<>();
        Node temp = head;
        returnMylinkedList.addFirst((E) temp.data);
        temp = temp.next;
        while (temp != null) {
            returnMylinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return returnMylinkedList;
    }


    public Object getFirst() {
        return head.data;
    }

    public Object getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;

    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public boolean constance(E element) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.data.equals(element)) {
                return 1;
            }
        }
        return -1;
    }
}

