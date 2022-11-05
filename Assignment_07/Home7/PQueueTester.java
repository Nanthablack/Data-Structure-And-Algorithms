public class PQueueTester {
    public static void main(String[] args) {
        MyPQueue queue = new MyPQueue();
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(9);
        queue.enqueue(8);
        queue.enqueue(7);

        System.out.println(queue);

        queue.dequeue();

        System.out.println(queue);

        System.out.println(queue.front());
    }
}