// นายศิริวัจน์ ตรังคานุวัฒน์ 63050191

public class MyStackLString {
    Node top = null;

    static class Node { // inner class
        String data;
        Node next;

        public Node(String d) {
            data = d;
        }
    }

    // public void add(String d) {
    //     Node p = new Node(d);
    //     p.next = top;
    //     top = p;
    // }

    public void push(String d) {
        Node p = new Node(d);
        p.next = top;
        top = p;
    }

    public String pop() {
        String d = top.data;
        top = top.next;
        return d;
    }

    public String top() {
        return top.data;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("head");
        Node p = top;
        while (p != null) {
            sb.append("-->[");
            sb.append(p.data);
            sb.append("]");
            p = p.next;
        }
        sb.append("->null");
        return new String(sb);
    }
}