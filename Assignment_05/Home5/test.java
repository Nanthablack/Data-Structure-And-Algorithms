
public class test {
    public static void main(String[] args) {
        int[] values = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
        MyStackA s = new MyStackA();
        for (int i = 0; i < values.length; i++)
            s.push(values[i]);
        System.out.println(s.toString());
        int n = 25;
        for (int i = 0; i < 4; i++) {
            n += s.pop();
        }
        for (int i = 0; i < 2; i++) {
            n -= s.pop();
        }
        System.out.println(n);
        int nk = 25 + 19 + 17 + 15 + 13 - 11 - 9;
        System.out.println(nk);
    }

}
