public class QueueTester {
    public static void main(String[] args) {
        MyQueueA queue = new MyQueueA();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);
        System.out.println(queue);
        // -----------------------------------------------------------------------------------------------------------------------
        queue.dequeue();
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);
        // -----------------------------------------------------------------------------------------------------------------------
        queue.enqueue(17);
        queue.enqueue(18);
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

        System.out.println(queue.front());

        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.front());
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);

        System.out.println(queue.front());
        System.out.println(queue.isEmpty());
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.isEmpty());

        /*
         * 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
         */
        System.out.println();
        /*
         * 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
         */

        MyQueueL que = new MyQueueL();
        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);
        que.enqueue(2);
        que.enqueue(3);
        que.enqueue(2);
        que.enqueue(5);
        que.enqueue(6);
        System.out.println(que);

        que.dequeue();
        System.out.println(que);

        que.dequeue();
        System.out.println(que);

        que.dequeue();
        System.out.println(que);

        que.dequeue();
        System.out.println(que);

        que.dequeue();
        System.out.println(que);

        que.enqueue(7);
        que.enqueue(8);
        System.out.println(que);

        System.out.println(que.front());

        que.dequeue();
        System.out.println(que);
        que.dequeue();
        System.out.println(que);
        que.dequeue();
        System.out.println(que);
        que.dequeue();
        System.out.println(que);
        que.dequeue();
        System.out.println(que);

        System.out.println(que.isEmpty());

    }
}
