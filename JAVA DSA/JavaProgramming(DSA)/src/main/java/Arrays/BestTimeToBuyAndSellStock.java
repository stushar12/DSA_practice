package Arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println("Profit made is: " + bestTimeToBuyAndSellStock(arr));

    }

    static int bestTimeToBuyAndSellStock(int[] arr) {
        int buyPrice = arr[0];
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            buyPrice = Math.min(buyPrice, arr[i]);
            profit = Math.max(profit, arr[i] - buyPrice);
        }

        return profit;
    }
}
