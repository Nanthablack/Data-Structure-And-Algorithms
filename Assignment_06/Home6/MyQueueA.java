public class MyQueueA {

    int MAX_SIZE = 100;
    double queue[] = new double[MAX_SIZE];
    int head = 0, tail = 0;

    public void enqueue(double d) {

        queue[tail] = d;
        tail = (tail + 1) % MAX_SIZE;

    }

    public double dequeue() {
        double d = queue[head];
        head = (head + 1) % MAX_SIZE;
        return d;
    }

    public double front() {

        return queue[head];

    }

    public boolean isFull() {

        return ((tail + 1) % MAX_SIZE) == head;

    }

    public boolean isEmpty() {

        return head == tail;

    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = head; i != tail; i = (i + 1) % MAX_SIZE) {
            sb.append(queue[i]);
            sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

}