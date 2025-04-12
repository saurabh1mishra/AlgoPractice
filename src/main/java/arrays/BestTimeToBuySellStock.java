package arrays;

/**
 * https://medium.com/theleanprogrammer/best-time-to-buy-and-sell-stock-c4ff30e56e4e
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

/**
 * Time Complexity — O(n)
 * Space Complexity -O(1)
 */

public class BestTimeToBuySellStock {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int min_price = prices[0]; // min so far
        int max_profit = 0;

        for (int i = 1; i < prices.length; i++) {
            min_price = Math.min(min_price, prices[i]);
            max_profit = Math.max(max_profit, prices[i] - min_price);
        }

        return max_profit;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }
}
