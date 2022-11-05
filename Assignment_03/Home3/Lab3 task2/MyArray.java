public class MyArray {
    int MAX_SIZE = 5;
    int data[] = new int[MAX_SIZE];
    int size = 0;

    // public void add(int d) {
    // data[size++] = d;
    // }

    public int add(int d) {
        if (isFull())
            return -1;
        data[size++] = d;
        return size;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int d, int index) {
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = d;
        size++;
    }

    public int find(int d) {
        for (int i = 0; i < size; i++) {
            if (data[i] == d) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int d) {
        int a = 0, b = size - 1;
        while (a <= b) {
            int m = (a + b) / 2;
            if (data[m] == d)
                return m;
            if (d < data[m])
                b = m - 1;
            else
                a = m + 1; // d>data[m]
        }
        return -1;
    }

    public void deleteU(int index) {
        data[index] = data[size--];
    }

    public void deleteO(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    void expandsB() { // version B
        MAX_SIZE = 2 * MAX_SIZE;
        int newData[] = new int[MAX_SIZE];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]);
            sb.append(",");
        }
        if (size > 0)
            sb.append(data[size - 1]);
        sb.append("]");
        return sb.toString();
    }
}
