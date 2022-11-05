public class MyMinHeap {
    int MAX_SIZE = 100;
    int heap[] = new int[MAX_SIZE];
    int size = 0;
    int count = 0;

    public void insert(int d) {
        count++;
        int p = size;
        heap[p] = d;
        int parent = (p - 1) / 2;
        while ((p > 0) && (heap[p] < heap[parent])) {
            swap(p, parent);
            p = parent;
            parent = (p - 1) / 2;
        }
        size++;
    }

    void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public int remove() {
        count--;
        int d = heap[0];
        heap[0] = heap[--size];
        int p = 0;
        while (true) {
            int left = 2 * p + 1;
            if (left >= size)
                break; // no child
            int right = 2 * p + 2;
            if (right == size) { // one child
                if (heap[p] > heap[left])
                    swap(p, left);
                break; // no more child, nothing to do
            } else { // two childs
                int q = heap[left] < heap[right] ? left : right;
                if (heap[p] > heap[q])
                    swap(p, q);
                else
                    break;
                p = q;
            }
        } // end while

        return d;
    }

    public int peek() {
        return heap[count];
    }

    public boolean isFull() {
        return count == MAX_SIZE - 1;
    }

    public boolean isEmpty() {
        return count == 0;

    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i <= size / 2; i++) {

            if (heap[i] != 0) {
                sb.append(" HEAD  : " + heap[i]);
            } else {
                sb.append(" HEAD  :  ");
            }
            if (heap[2 * i + 1] != 0) {
                sb.append(" LEFT  : " + heap[2 * i + 1]);
            } else {
                sb.append(" LEFT  :  ");
            }
            if (heap[2 * i + 2] != 0) {
                sb.append(" RIGHT : " + heap[2 * i + 2] + "\n");
            } else {
                sb.append(" RIGHT :  \n");
            }
        }
        return sb.toString();
    }
}