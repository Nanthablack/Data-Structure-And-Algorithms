public class MyQueueL {

    public class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
        }
    }

    Node head = null, tail;

    public void enqueue(int d) {

        Node p = new Node(d);
        if (head == null)
            head = tail = p;
        else {
            tail.next = p;
            tail = tail.next;
        }

    }

    public int dequeue() {

        int d = head.data;
        head = head.next;
        return d;

    }

    public int front() {

        return head.data;

    }

    public boolean isFull() {

        return false;

    }

    public boolean isEmpty() {

        return head == null;

    }

    public String toString() {
        StringBuffer sb = new StringBuffer("head ");
        Node p = head;
        while (p != null) {
            sb.append("--> [");
            sb.append(p.data);
            sb.append("] ");
            p = p.next;
        }
        sb.append("--> null");
        return new String(sb);
    }

}
