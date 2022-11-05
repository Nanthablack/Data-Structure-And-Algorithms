public class Knapsackteacher {

    static int items = 6;
    static int values[] = { 20, 5, 10, 50, 40, 26 };
    static int weights[] = { 1, 2, 3, 8, 7, 4 };
    static int maxWeight = 10;
    static int minIndex = 0;
    static int maxIndex = 3;

    static boolean knapsack[] = new boolean[items];

    static boolean bestKnapsack[] = new boolean[items];
    static int bestValue = 0;

    static void compute(int index, int weight) {
        if (weight > maxWeight)
            return;
        if ((knapsack[minIndex]) && (knapsack[maxIndex]))
            return;
        if (index == items) {
            // check if the heaviest and lightest are there at the same time

            // check even number of item
            int count = 0;
            for (int i = 0; i < items; i++)
                if (knapsack[i])
                    count++;
            if (count % 2 == 1)
                return;

            // check if best value and record
            int value = 0;
            for (int i = 0; i < items; i++)
                if (knapsack[i])
                    value += values[i];
            if (value > bestValue) {
                bestValue = value;
                System.arraycopy(knapsack, 0, bestKnapsack, 0, items);
            }
        } else {
            knapsack[index] = false;
            compute(index + 1, weight);
            knapsack[index] = true;
            compute(index + 1, weight + weights[index]);
        }
    }

    public static void main(String[] args) {
        compute(0, 0);
        System.out.println("Max Value: " + bestValue);
        for (int i = 0; i < items; i++) {
            if (bestKnapsack[i])
                System.out.print(i + " ");
        }
    }
}