public class MyStackL {

    public class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
        }
    }

    Node head = null;

    public void push(int d) {

        Node p = new Node(d);
        p.next = head;
        head = p;

    }

    public int pop() {

        int d = head.data;
        head = head.next;
        return d;

    }

    public int top() {
        return head.data;
    }

    public boolean isFull() {
        return false;

    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("llun ");
        Node p = head;
        while (p != null) {
            sb.append(">-- ]");
            sb.append(p.data);
            sb.append("[ ");
            p = p.next;
        }
        sb.append(">-- daeh");
        sb.reverse();
        return new String(sb);
    }

}
