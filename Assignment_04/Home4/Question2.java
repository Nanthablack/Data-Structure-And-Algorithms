import java.util.*;

class Del_N_after_M {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.print("M = ");
        int M = scan.nextInt();
        System.out.print("N = ");
        int N = scan.nextInt();
        System.out.println();

        Node H = null;
        for (int i = 10; i > 0; i--) {
            H = push(H, i);
        }

        System.out.print("Given is :");
        PLizt(H);
        skipMN(H, M, N);

        System.out.print("After Deletion is :");
        PLizt(H);
    }

    static Node N = null;

    static class Node {

        int data;
        Node next;
    }

    static void skipMN(Node head, int M, int N) {

        Node e = null;
        Node cur = head, t;
        int i;

        while (cur != e) {

            for (i = 1; i < M && cur != e; i++)
                cur = cur.next;

            if (cur == e)
                return;

            t = cur.next;
            for (i = 1; i <= N && t != e; i++) {
                t = t.next;
            }
            cur.next = t;
            cur = t;
        }
    }

    static Node push(Node ref, int d) {

        Node q = new Node();
        q.data = d;
        q.next = (ref);
        (ref) = q;

        return ref;
    }

    static void PLizt(Node p) {
        while (p != N) {
            System.out.print(" " + p.data);
            p = p.next;
        }
        System.out.println();
    }

}