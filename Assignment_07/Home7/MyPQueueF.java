public class MyPQueueF {

    FibonacciMinPQ<Integer> heap = new FibonacciMinPQ<Integer>();

    public void enqueue(int d) {
        heap.insert(d);

    }

    public int dequeue() {
        return (int) heap.delMin();
    }

    public int front() {
        return (int) heap.minKey();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

}
