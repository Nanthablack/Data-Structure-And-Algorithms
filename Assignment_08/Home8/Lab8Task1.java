import java.util.*;

class Lab8Task1 {
    public static void main(String[] args) {
        int[] a = { 1, 3, 4, 7 };

        printArray(a, 0);
        System.out.println();

        printReverse(a, 0);
        System.out.println();

        printArrayAndReverse(a, 0);

    }

    static void printArray(int a[], int i) {
        if (i == a.length)
            return;
        System.out.print(a[i] + " ");
        printArray(a, i + 1);

    }

    static void printReverse(int a[], int i) {
        if (i == a.length)
            return;
        System.out.print(a[a.length - (i + 1)] + " ");
        printReverse(a, i + 1);

    }

    static void printArrayAndReverse(int a[], int i) {
        printArray(a, 0);
        printReverse(a, 0);
    }
}