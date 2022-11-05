public class PQueueFTester {
    public static void main(String[] args) {
        MyPQueueF queue = new MyPQueueF();
        queue.enqueue(1);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(9);
        queue.enqueue(8);
        queue.enqueue(7);
        queue.enqueue(11);

        System.out.println(queue);

        queue.dequeue();

        System.out.println(queue);

        System.out.println(queue.front());
    }
}