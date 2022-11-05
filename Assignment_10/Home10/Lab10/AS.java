import java.util.Random;

public class AS {
    static int nextGaussian(Random r, int mean) {
        return (int) (r.nextGaussian() * mean / 2) + mean;
    }

    public static void main(String[] args) {
        int start = 1000;
        int step = 1000;

        Random r = new Random();

        SplayTree splay = new SplayTree();

        for (int n = start; n < start + 10 * step; n += step) {

            AVLTree avl = new AVLTree();
            System.out.println("n: " + n);

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                avl.add(i);
            System.out.println("avl ordered build : " + (System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                avl.search(i);
            System.out.println("avl ordered access : " + (System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                avl.search(nextGaussian(r, n));
            System.out.println("avl gaussian accese : " + (System.currentTimeMillis() - startTime));

            System.out.println();

        }

        // random AVl
        for (int n = start; n < start + 10 * step; n += step) {

            AVLTree avl = new AVLTree();
            System.out.println("n: " + n);

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                avl.add(r.nextInt(n));
            System.out.println("avl random build : " + (System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                avl.search(i);
            System.out.println("avl ordered access : " + (System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++)
                avl.search(nextGaussian(r, n));
            System.out.println("avl gaussian access : " + (System.currentTimeMillis() - startTime));

            System.out.println();

        }

    }
}