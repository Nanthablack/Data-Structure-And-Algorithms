class Knapsackweb {
    public static void main(String args[]) {
        int[] value = { 20, 5, 10, 50, 40, 25 }, weight = { 1, 2, 3, 8, 7, 4 };
        int W = 10;
        int n = value.length;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int w : weight) {
            if (max < w)
                max = w;
            if (min > w)
                min = w;
        }
        System.out.println(MyknapSack(W, weight, value, n, (n % 2 == 0), min, max, false));
    }

    static int MyknapSack(int W, int wt[], int val[], int n, boolean isEven, int min, int max,
            boolean ifMaxMinInKnapSack) {
        if (n == 0 || W == 0) {
            if (isEven)
                return 0;
            else
                return Integer.MIN_VALUE;
        }
        if (wt[n - 1] > W)
            return MyknapSack(W, wt, val, n - 1, isEven, max, min, ifMaxMinInKnapSack);

        if (wt[n - 1] == min || wt[n - 1] == max) {
            if (ifMaxMinInKnapSack) {
                return MyknapSack(W, wt, val, n - 1, isEven, max, min, ifMaxMinInKnapSack);
            } else {
                return max(val[n - 1] + MyknapSack(W - wt[n - 1], wt, val, n - 1, !isEven, max, min, true),
                        MyknapSack(W, wt, val, n - 1, isEven, max, min, false));

            }
        }

        else
            return max(val[n - 1] + MyknapSack(W - wt[n - 1], wt, val, n - 1, !isEven, max, min, ifMaxMinInKnapSack),
                    MyknapSack(W, wt, val, n - 1, isEven, max, min, ifMaxMinInKnapSack));
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}