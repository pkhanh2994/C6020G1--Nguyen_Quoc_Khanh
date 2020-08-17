package stackandqueue.thuc_hanh;

public class QueueClient {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.enqueue(4);
        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(67);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

    }
}
