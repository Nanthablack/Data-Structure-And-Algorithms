
public class MyLinkedList {

    Node head = null, tail;

    public class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
        }
    }
    // Implement the following method
    // --------------------------------------------------------------------------------------------------------

    // - void add(int d) – add into a linked list
    public void add(int d) {

        Node p = new Node(d);
        if (head == null)
            head = tail = p;
        else {
            tail.next = p;
            tail = tail.next;
        }

    }

    // - void insert(int d) – insert into an ordered linked list
    public void insert(int d, Node p) {
        Node q = new Node(d);
        q.next = p.next;
        p.next = q;

    }

    public void insert(int d) {
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while ((p.next != null) && (p.next.data < d)) {
            p = p.next;
        }
        if ((p.next != null) && (p.next.data >= d)) {
            Node q = new Node(d);
            q.next = p.next;
            p.next = q;
        }
        head = t.next;
    }

    // - Node find(int d) – find in a linked list
    public Node find(int d) {
        Node p = head;
        while (p != null) {
            if (p.data == d)
                return p;
            p = p.next;
        }
        return null;
    }

    // - void delete(int d) – delete from a linked list
    public void delete(int d) {
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while ((p.next != null) && (p.next.data != d)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        head = t.next;
    }

    // --------------------------------------------------------------------------------------------------------

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

    // --------------------------------------------------------------------------------------------------------

    public int getAt(int i) {
        Node p = head;
        while (i > 0) {
            p = p.next;
            i--;
        }
        return p.data;
    }

    public void setAt(int d, int i) {
        Node p = head;
        while (i > 0) {
            p = p.next;
            i--;
        }
        p.data = d;
    }

    public void delete(Node p) {
        p.next = p.next.next;
    }

    // --------------------------------------------------------------------------------------------------------
}
