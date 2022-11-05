import java.util.*;

class Lab8Knapsack {
    public static void main(String[] args) {
        int[] index = { 0, 1, 2, 3, 4, 5 };
        int[] value = { 20, 5, 10, 50, 40, 25 };
        int[] weight = { 1, 2, 3, 8, 7, 4 };
        int W = 10;
        System.out.print(knapSack(W, weight, value, 6));
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int knapSack(int W, int wt[], int val[], int n) {

        if (n == 0 || W == 0) {

            return 0;
        }

        if (wt[n - 1] > W) {

            return knapSack(W, wt, val, n - 1);

        } else {

            return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
        }
    }

}
