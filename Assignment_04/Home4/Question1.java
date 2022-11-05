import java.util.*;

class ROTATE {
    public static void main(String[] args) {

        push(60);
        push(50);
        push(40);
        push(30);
        push(20);
        push(10);

        System.out.println();
        System.out.print("Given  : ");
        PLizt(head);

        Scanner scan = new Scanner(System.in);
        System.out.print("\nk = ");
        int n = scan.nextInt();
        Rotate(n);

        System.out.print("Rotated : ");
        PLizt(head);
        System.out.println();
    }

    static Node head = null;
    static final Node N = null;

    static class Node {

        int data;
        Node next;
    }

    static void Rotate(int d) {
        if (d == 0)
            return;

        Node circle = head;

        while (circle.next != N) {
            circle = circle.next;
        }
        circle.next = head;
        circle = head;

        int i = 0;
        while (i < d - 1) {
            circle = circle.next;
            i++;
        }

        head = circle.next;
        circle.next = N;
    }

    static void push(int p) {

        Node q = new Node();
        q.data = p;
        q.next = head;
        head = q;
    }

    static void PLizt(Node p) {
        while (p != N) {
            System.out.print(p.data + " ");
            p = p.next;
        }
    }

}
