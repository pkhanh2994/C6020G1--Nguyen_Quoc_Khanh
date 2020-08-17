package stackandqueue.thuc_hanh;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        Node.MyLinkedListQueue queue = new Node.MyLinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.dequeue();
        queue.dequeue();
        System.out.println("Dequeued item is " + queue.dequeue().key);
    }
}
