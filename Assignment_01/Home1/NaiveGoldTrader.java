import java.util.Scanner;

public class NaiveGoldTrader {
    static int readGoldPrices(int goldPrices[]) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while (in.hasNext()) {
            goldPrices[n++] = in.nextInt();
        }
        in.close();
        return n;
    }

    public static void main(String args[]) {
        int goldPrices[] = new int[1000000];
        int n = readGoldPrices(goldPrices);
        int bestBuyDate = 0;
        int bestSellDate = 0;
        int maxProfit = Integer.MIN_VALUE;
        long count = 0;
        for (int buyDate = 0; buyDate < n - 1; buyDate++) {
            for (int sellDate = buyDate + 1; sellDate < n; sellDate++) {
                count++;
                int profit = goldPrices[sellDate] - goldPrices[buyDate];
                if (profit > maxProfit) {
                    maxProfit = profit;
                    bestBuyDate = buyDate;
                    bestSellDate = sellDate;
                }
            }
        }
        System.out.println("Number of days: " + n);
        System.out.println("Max profit is: " + maxProfit);
        System.out.println("Buy date: " + (bestBuyDate + 1));
        System.out.println("Sell date: " + (bestSellDate + 1));
        System.out.println("count: " + count);
    }
}
