
//palindrome 
import java.util.*;

class Palindrome {
    public static void main(String[] args) {

        Palindrome palindrom = new Palindrome();

        Scanner scan = new Scanner(System.in);
        System.out.println("[ ป้อนข้อความโปรแกรมทำการแยกข้อความให้เป็นตัวอักษรและหา Palindrome ]");
        System.out.print("ป้อนข้อความ : ");
        String word = scan.nextLine();
        char[] A = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            A[i] = word.charAt(i);
        }

        for (int i = 0; i < word.length(); i++) {

            palindrom.push(A[i]);
            palindrom.PLizt(palindrom.head);
            boolean x = palindrom.isPLD(palindrom.head);

            if (x != false) {
                System.out.println(" >> PALINDROME!");
                System.out.println("");
            } else {
                System.out.println(" (x)");
                System.out.println("");
            }

        }
    }

    static Node head = null, slow, fast, half;
    static Node N = null;

    static class Node {
        char data;
        Node next;

        Node(char d) {
            data = d;
            next = null;
        }
    }

    public boolean isPLD(Node head) {
        // isPLD ตรวจสอบว่าเป็นหรือไม่เป็น Palindrome

        slow = head;
        fast = head;
        Node Prevslow = head, midnode = N;
        boolean Palindrome = true;

        if (head != N && head.next != N) {

            while (fast != N && fast.next != N) {
                fast = fast.next.next;

                Prevslow = slow;
                slow = slow.next;
            }

            if (fast != N) {
                midnode = slow;
                slow = slow.next;
            }

            half = slow;
            Prevslow.next = N;
            reverse();

            Palindrome = Compare(head, half);
            reverse();

            if (midnode != N) {

                Prevslow.next = midnode;
                midnode.next = half;
            } else {

                Prevslow.next = half;
            }
        }
        return Palindrome;
    }

    public boolean Compare(Node one, Node two) {
        // เปรียบเทียบส่วนที่ 1 กับ 2 เท่ากันไหม ถ้าเท่ากัน ture ไม่เท่ากัน false

        while (one != N && two != N) {

            if (one.data == two.data) {

                one = one.next;
                two = two.next;
            } else {

                return false;
            }

        }

        if (one == N && two == N) {
            return true;
        }

        return false;
    }

    public void reverse() {

        Node next, prev = N;

        while (half != N) {

            next = half.next;
            half.next = prev;
            prev = half;
            half = next;
        }
        half = prev;
    }

    public void push(char p) {

        Node q = new Node(p);
        q.next = head;
        head = q;
    }

    public void PLizt(Node p) {
        while (p != null) {
            System.out.print(" " + p.data);
            p = p.next;
        }
        System.out.println();
    }

}