// นายศิริวัจน์ ตรังคานุวัฒน์ 63050191

public class MyQueueLString {
    Node head = null,tail;

    public class Node { // inner class
        String data;
        Node next;

        public Node(String d) {
            data = d;
        }
    }
    public void enqueue(String d){
        Node p = new Node(d);
        if(isEmpty()){
            head = tail = p;
        }
        else {
            tail.next = p;
            tail = tail.next;
        }
    }
    public String dequeue(){
        String d = head.data;
        head = head.next;
        return d;
    }
    public String front(){
        return head.data;
    }
    public boolean isFull(){
        return false;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder("head");
        Node a = head;
        while (a != null) {
            sb.append("-->[");
            sb.append(a.data);
            sb.append("]");
            a = a.next;
        }
        sb.append("->null");
        return sb.toString();
    }
    public String toString1(){
        StringBuilder sb1 = new StringBuilder("");
        Node a = head;
        while (a != null) {
            sb1.append(a.data);
            sb1.append(" ");
            a = a.next;
        }
        return sb1.toString();
    }
}